import configuration.DefaultConfiguration;

public final class Main {
  public static void main(final String[] args) {
    new Client(new DefaultConfiguration()).run();
  }
}
