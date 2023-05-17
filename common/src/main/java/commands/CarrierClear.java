package commands;

public final record CarrierClear() implements Carrier {
  public CommandIdentity identity() {
    return CommandIdentity.Clear;
  }
  public String syntax(){
    return "clear";
  }
}
