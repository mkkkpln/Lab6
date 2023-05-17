
package execution.commands;

import commands.CarrierReplaceIfLower;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandReplaceIfLower implements Command {
  private final CollectionManager collection;
  private final CarrierReplaceIfLower carrier;

  public CommandReplaceIfLower(final CarrierReplaceIfLower carrier, final CollectionManager collection) {
    this.carrier = carrier;
    this.collection = collection;
  }

  public ServerResponse execute() {
    var speed = collection.data().get(carrier.id()).impactSpeed();
    if (carrier.human().impactSpeed() < speed) {
      collection.data().put(carrier.id(), carrier.human());
      return new ServerResponse("Character successfully updated");
    } else
      return new ServerResponse("Character speed was not lower");
  }

  public String name() {
    return "replaceIfLower";
  }

  public String description() {
    return this.name() + " : replace a character if speed of impact is lower in the new one";
  }
}
