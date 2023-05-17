package execution.commands;

import commands.CarrierInsert;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandInsert implements Command {
  private final CollectionManager collection;
  private final CarrierInsert carrier;

  public CommandInsert(final CarrierInsert carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    final long elderKey;
    if (collection.data().size() == 0)
      elderKey = 0;
    else
      elderKey = collection.data().lastKey();
    collection.data().put(elderKey + 1, carrier.human());
    return new ServerResponse("Character successfully added");
  }

  public String name() {
    return "insert";
  }

  public String description() {
    return this.name() + " : inserts a character";
  }
}
