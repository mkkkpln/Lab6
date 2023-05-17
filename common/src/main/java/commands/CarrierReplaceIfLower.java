package commands;

import data.HumanBeing;

public final record CarrierReplaceIfLower(long id, HumanBeing human) implements Carrier {
  @Override
  public CommandIdentity identity() {
    return CommandIdentity.ReplaceIfLower;
  }

  public String syntax() {
    return "replaceifLower id human\n" +
        "where id: an integer\n" +
        "human: same parameters as those from insert\n" +
        new CarrierInsert(null).syntax();
  }
}
