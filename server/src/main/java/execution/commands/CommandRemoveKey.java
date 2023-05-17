package execution.commands;

import commands.CarrierRemoveKey;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandRemoveKey implements Command {
  private final CollectionManager collection;
  private final CarrierRemoveKey carrier;

  public CommandRemoveKey(final CarrierRemoveKey carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    collection.data().remove(carrier.id());
    return new ServerResponse("Deleted");
  }

  public String name() {
    return "removeKey";
  }

  public String description() {
    return this.name() + " : removes a character with a given id";
  }
}
