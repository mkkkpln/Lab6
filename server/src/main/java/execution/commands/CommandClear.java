package execution.commands;

import commands.CarrierClear;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandClear implements Command {
  final CollectionManager collection;

  public CommandClear(final CarrierClear carrier, final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    collection.data().clear();
    return new ServerResponse("clear executed");
  }

  public String name() {
    return "clear";
  }

  public String description() {
    return this.name() + " : clear the collection";
  }
}
