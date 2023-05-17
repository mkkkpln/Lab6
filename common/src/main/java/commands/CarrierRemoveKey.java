package commands;

public final record CarrierRemoveKey(long id) implements Carrier {

  @Override
  public CommandIdentity identity() {
    return CommandIdentity.RemoveKey;
  }

  public String syntax() {
    return "removeKey id\n" +
        "where id: an integer";
  }
}
