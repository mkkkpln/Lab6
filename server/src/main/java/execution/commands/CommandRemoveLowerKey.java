
package execution.commands;

import commands.CarrierRemoveLowerKey;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandRemoveLowerKey implements Command {
  private final CollectionManager collection;
  private final CarrierRemoveLowerKey carrier;

  public CommandRemoveLowerKey(final CarrierRemoveLowerKey carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    while (collection.data().firstKey() < carrier.id()) {
      collection.data().pollFirstEntry();
    }
    return new ServerResponse("Deleted");
  }

  public String name() {
    return "removeLowerKey";
  }

  public String description() {
    return this.name() + " : removes all characters with id lesser than the defined";
  }
}
