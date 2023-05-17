package execution.commands;

import java.util.stream.Collectors;

import commands.CarrierHelp;
import data.ServerResponse;
import execution.Command;
import execution.CommandManager;

public final class CommandHelp implements Command {
  public CommandHelp(final CarrierHelp carrier) {
  }

  public ServerResponse execute() {
    return new ServerResponse(new CommandManager()
        .commandsStream()
        .map(x -> x.description())
        .collect(Collectors.joining("\n")));
  }

  public String name() {
    return "help";
  }

  public String description() {
    return this.name() + " : output help for available commands";
  }
}
