package execution.commands;

import commands.CarrierInfo;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandInfo implements Command {
  private final CollectionManager collection;

  public CommandInfo(final CarrierInfo carrier, final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    final StringBuilder response = new StringBuilder();
    response.append("Тип: " + collection.data().getClass().toString() + '\n');
    response.append("Количество записей: " + collection.data().size());
    return new ServerResponse(response.toString());
  }

  public String name() {
    return "info";
  }

  public String description() {
    return this.name() + " : shows database stats";
  }
}
