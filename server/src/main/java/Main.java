import java.io.IOException;
import java.lang.System.Logger.Level;

import configuration.DefaultConfiguration;

public final class Main {
  public static void main(final String[] args) {
    try {
      new Server(new DefaultConfiguration()).run();
    } catch (IOException e) {
      System.getLogger(Main.class.toString()).log(Level.ERROR, "Startup failure");
    }
  }
}
// gradle build;
// java -jar server/build/libs/server-1.0-SNAPSHOT-all.jar