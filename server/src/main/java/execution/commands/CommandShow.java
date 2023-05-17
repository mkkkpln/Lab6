package execution.commands;

import java.util.stream.Collectors;

import commands.CarrierShow;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandShow implements Command {
  private final CollectionManager collection;

  public CommandShow(final CarrierShow carrier, final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    if (collection.data().size() > 0) {
      return new ServerResponse(collection
          .data()
          .entrySet()
          .stream()
          .map(entry -> entry.getValue().toString())
          .collect(Collectors.joining("\n")));
    } else {
      return new ServerResponse("Collection is empty");
    }
  }

  public String name() {
    return "show";
  }

  public String description() {
    return this.name() + " : shows characters";
  }
}
