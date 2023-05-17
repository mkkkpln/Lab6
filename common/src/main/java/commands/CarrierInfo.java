package commands;

public final record CarrierInfo() implements Carrier {

  @Override
  public CommandIdentity identity() {
    return CommandIdentity.Info;
  }

  public String syntax() {
    return "info";
  }
}
