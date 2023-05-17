import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import Parsing.CarrierParser;
import Parsing.TextUI;
import Parsing.exceptions.ParsingException;
import commands.CarrierHelp;
import commands.ShellCarrier;
import configuration.Configuration;
import data.ServerResponse;

public final class Client implements Runnable {
  private final Configuration config;
  private final TextUI tui;

  public Client(final Configuration config) {
    this.tui = new TextUI();
    this.config = config;

  }

  @Override
  public void run() {
    this.tui.greeting();
    sendCommand(new ShellCarrier(new CarrierHelp()));
    while (true) {
      parseCommand();
    }
  }

  private void parseCommand() {
    try {
      CarrierParser parser = new CarrierParser();
      try {
        sendCommand(new ShellCarrier(parser.parse(this.tui.readLine())));
      } catch (ParsingException e) {
        System.out.println(e.getMessage() + "\n");
        return;
      }
    } catch (IOException | ClassCastException e) {
      System.out.println("Ошибка работы клиента");
    }
  }

  private void sendCommand(final ShellCarrier carrier) {
    try (final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(config.host(), config.port()))) {
      socketChannel.configureBlocking(true);
      try (final ObjectOutputStream out = new ObjectOutputStream(socketChannel.socket().getOutputStream())) {
        out.writeObject(carrier);
        out.flush();
        try (final ObjectInputStream in = new ObjectInputStream(socketChannel.socket().getInputStream())) {
          final var response = (ServerResponse) in.readObject();
          System.out.println(response.message());
        } catch (ClassNotFoundException e) {
          System.out.println("Server sent incorrect response");
        }
      }
    } catch (ConnectException e) {
      System.out.println("Server not responding");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e1) {
        System.out.println("Thread suspend exception");
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Sending data to server failed");
    }
  }
}
