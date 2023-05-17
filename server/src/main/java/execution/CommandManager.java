package execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import execution.commands.CommandClear;
import execution.commands.CommandHelp;
import execution.commands.CommandInfo;
import execution.commands.CommandInsert;
import execution.commands.CommandPrintAscending;
import execution.commands.CommandPrintFieldDescendingMood;
import execution.commands.CommandRemoveGreater;
import execution.commands.CommandRemoveKey;
import execution.commands.CommandRemoveLowerKey;
import execution.commands.CommandReplaceIfLower;
import execution.commands.CommandShow;
import execution.commands.CommandSumOfImpactSpeed;
import execution.commands.CommandUpdateID;

public final class CommandManager {
  private final Collection<Command> commands;

  public CommandManager() {
    ArrayList<Command> tmp = new ArrayList<Command>();
    tmp.add(new CommandHelp(null));
    tmp.add(new CommandClear(null, null));
    tmp.add(new CommandInfo(null, null));
    tmp.add(new CommandInsert(null, null));
    tmp.add(new CommandPrintAscending(null, null));
    tmp.add(new CommandPrintFieldDescendingMood(null, null));
    tmp.add(new CommandRemoveGreater(null, null));
    tmp.add(new CommandRemoveKey(null, null));
    tmp.add(new CommandRemoveLowerKey(null, null));
    tmp.add(new CommandReplaceIfLower(null, null));
    tmp.add(new CommandShow(null, null));
    tmp.add(new CommandSumOfImpactSpeed(null, null));
    tmp.add(new CommandUpdateID(null, null));
    commands = tmp;
  }

  public Stream<Command> commandsStream() {
    return commands.stream();
  }
}
