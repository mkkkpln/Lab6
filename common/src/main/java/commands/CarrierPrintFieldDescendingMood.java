package commands;

public final record CarrierPrintFieldDescendingMood() implements Carrier {
  @Override
  public CommandIdentity identity() {
    return CommandIdentity.PrintFieldDescendingMood;
  }
  public String syntax(){
    return "printFieldDescendingMood";
  }
}
