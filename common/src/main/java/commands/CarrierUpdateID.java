package commands;

import data.HumanBeing;

public final record CarrierUpdateID(long id, HumanBeing human) implements Carrier {
  public CommandIdentity identity() {
    return CommandIdentity.UpdateID;
  }

  public String syntax() {
    return "updateId id human\n" +
        "where id: an integer\n" +
        "human: same parameters as those from insert\n" +
        new CarrierInsert(null).syntax();
  }
}
