
package execution.commands;

import commands.CarrierUpdateID;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandUpdateID implements Command {
  private final CollectionManager collection;
  private final CarrierUpdateID carrier;

  public CommandUpdateID(final CarrierUpdateID carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    collection.data().put(carrier.id(), carrier.human());
    return new ServerResponse("Character successfully updated");
  }

  public String name() {
    return "updateId";
  }

  public String description() {
    return this.name() + " : updates a character with a predefined ID";
  }
}
