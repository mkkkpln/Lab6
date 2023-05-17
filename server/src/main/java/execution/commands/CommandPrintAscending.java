package execution.commands;

import java.util.stream.Collectors;

import commands.CarrierPrintAscending;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandPrintAscending implements Command {
  private final CollectionManager collection;

  public CommandPrintAscending(final CarrierPrintAscending carrier, final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    if (collection.data().size() > 0) {
      return new ServerResponse(collection
          .data()
          .entrySet()
          .stream()
          .map(entry -> entry.getKey().toString() + ": " + entry.getValue().toString())
          .collect(Collectors.joining("\n")));
    } else {
      return new ServerResponse("Collection is empty");
    }
  }

  public String name() {
    return "printAscending";
  }

  public String description() {
    return this.name() + " : prints characters with with their IDs in ascending order";
  }
}
