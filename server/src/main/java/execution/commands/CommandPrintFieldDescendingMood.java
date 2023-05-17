
package execution.commands;

import java.util.stream.Collectors;

import commands.CarrierPrintFieldDescendingMood;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandPrintFieldDescendingMood implements Command {
  private final CollectionManager collection;

  public CommandPrintFieldDescendingMood(final CarrierPrintFieldDescendingMood carrier,
      final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    if (collection.data().size() > 0) {
      return new ServerResponse(collection
          .data()
          .entrySet()
          .stream()
          .sorted((o1, o2) -> o1.getValue().mood().compareTo(o2.getValue().mood()))
          .map(entry -> entry.getValue().toString())
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
