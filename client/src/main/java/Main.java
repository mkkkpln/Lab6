import configuration.DefaultConfiguration;

public final class Main {
  public static void main(final String[] args) {
    new Client(new DefaultConfiguration()).run();
  }
}

// java -jar client/build/libs/client-1.0-SNAPSHOT-all.jar
