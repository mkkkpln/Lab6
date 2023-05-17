import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import commands.Carrier;
import commands.ShellCarrier;
import configuration.Configuration;
import data.PersistenceManager;
import data.ServerResponse;
import execution.CommandHandler;
import execution.commands.CommandSave;

public final class Server implements Runnable {
  private final Configuration config;
  private final int PORT;
  private final PersistenceManager persistence;
  private final Logger logger;

  public Server(final Configuration config) throws IOException {
    this.config = config;
    this.persistence = new PersistenceManager(null).load(config.persistenceCollection());
    this.PORT = config.port();
    logger = System.getLogger(this.getClass().toString());
  }

  @Override
  public void run() {
    try (final var server = openServer()) {
      while (true) {
        try {
          connectToClient(server);
        } catch (final IOException e) {
          logger.log(Level.INFO, "Client connection aborted");
        }
      }
    } catch (final IOException e) {
      logger.log(Level.INFO, "Network failure");
    }
  }

  private ServerSocketChannel openServer() throws IOException {
    final var server = ServerSocketChannel.open();
    server.socket().bind(new InetSocketAddress(PORT));
    return server;
  }

  private void connectToClient(final ServerSocketChannel ssc) throws IOException {
    try (final SocketChannel channel = ssc.accept()) {
      logger.log(Level.INFO, "Connecting to client");
      try (final ObjectInputStream ois = new ObjectInputStream(channel.socket().getInputStream())) {
        final Object object = ois.readObject();
        logger.log(Level.INFO, "Received object");
        final ShellCarrier carrier = (ShellCarrier) object;
        try (final ObjectOutputStream oos = new ObjectOutputStream(channel.socket().getOutputStream())) {
          oos.writeObject(clientEvent(carrier.carrier()));
          final var saving = new CommandSave(this.persistence, this.config.persistenceCollection()).execute();
          logger.log(Level.INFO, saving.message());
        }
      } catch (final ClassNotFoundException e) {
        e.printStackTrace();
        logger.log(Level.WARNING, "Warning: Corrupt message from a client");
      }
    }
  }

  private ServerResponse clientEvent(final Carrier carrier) throws ClassNotFoundException, IOException {
    return new CommandHandler().handle(carrier, this.persistence.collection());
  }
}
