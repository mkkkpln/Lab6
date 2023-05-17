package commands;

public final record CarrierShow() implements Carrier {
  public CommandIdentity identity() {
    return CommandIdentity.Show;
  }

  public String syntax() {
    return "show";
  }
}
