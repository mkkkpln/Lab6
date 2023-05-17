package commands;

public final record CarrierRemoveGreater(long id) implements Carrier {
  @Override
  public CommandIdentity identity() {
    return CommandIdentity.RemoveGreater;
  }

  public String syntax() {
    return "removeGreater id\n" +
        "where id: an integer";
  }
}
