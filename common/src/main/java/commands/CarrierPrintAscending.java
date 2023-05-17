package commands;

public final record CarrierPrintAscending() implements Carrier {

  @Override
  public CommandIdentity identity() {
    return CommandIdentity.PrintAscending;
  }

  public String syntax() {
    return "printAscending";
  }
}
