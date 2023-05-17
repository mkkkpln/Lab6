package commands;

public final record CarrierRemoveLowerKey(long id) implements Carrier {
  public CommandIdentity identity() {
    return CommandIdentity.RemoveLowerKey;
  }

  public String syntax() {
    return "removeLowerKey id\n" +
        "where id: an integer";
  }
}
