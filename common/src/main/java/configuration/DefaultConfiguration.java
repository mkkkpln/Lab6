package configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Path;

public final class DefaultConfiguration implements Configuration {
  private final int port = 3500;

  public InetAddress host() {
     return InetAddress.getLoopbackAddress();
//    try {
//      return InetAddress.getByName("se.ifmo.ru");
//    } catch (UnknownHostException e) {
//      e.printStackTrace();
//      return InetAddress.getLoopbackAddress();
//    }
  }

  public final int port() {
    return this.port;
  }

  public final Path persistenceDirectory() {
    return Path.of(System.getProperty("user.home"));
  }

  public final Path persistenceCollection() {
    return this.persistenceDirectory().resolve(".mkkkpln_lab6_collection");
  }

  @Override
  public boolean extensiveLogging() {
    return false;
  }
}
