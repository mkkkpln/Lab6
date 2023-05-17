package configuration;

import java.net.InetAddress;
import java.nio.file.Path;

public interface Configuration {
  public InetAddress host();

  public int port();

  public Path persistenceDirectory();

  public Path persistenceCollection();

  public boolean extensiveLogging();
}
