package execution.commands;

import commands.CarrierRemoveGreater;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandRemoveGreater implements Command {
  private final CollectionManager collection;
  private final CarrierRemoveGreater carrier;

  public CommandRemoveGreater(final CarrierRemoveGreater carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    while (collection.data().lastKey() > carrier.id()) {
      collection.data().pollLastEntry();
    }
    return new ServerResponse("Deleted");
  }

  public String name() {
    return "removeGreater";
  }

  public String description() {
    return this.name() + " : removes all characters with id greater than the defined";
  }
}
