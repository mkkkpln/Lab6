package commands;

public final record CarrierHelp() implements Carrier {

  public CommandIdentity identity() {
    return CommandIdentity.Help;
  }

  public String syntax() {
    return "help";
  }
}
