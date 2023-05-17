package execution;

import java.io.IOException;
import commands.Carrier;
import commands.CarrierClear;
import commands.CarrierHelp;
import commands.CarrierInfo;
import commands.CarrierInsert;
import commands.CarrierPrintAscending;
import commands.CarrierPrintFieldDescendingMood;
import commands.CarrierRemoveGreater;
import commands.CarrierRemoveKey;
import commands.CarrierRemoveLowerKey;
import commands.CarrierReplaceIfLower;
import commands.CarrierShow;
import commands.CarrierSumOfImpactSpeed;
import commands.CarrierUpdateID;
import data.CollectionManager;
import data.ServerResponse;
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

public final class CommandHandler {
  public ServerResponse handle(final Carrier carrier, final CollectionManager collection)
      throws IOException, ClassNotFoundException {
    switch (carrier.identity()) {
      case Clear:
        return new CommandClear((CarrierClear) carrier, collection).execute();
      case ExecuteScript:
        return new ServerResponse("Error: client-side operation requested");
      case Exit:
        return new ServerResponse("Error: client sent exit command instead of executing it itself");
      case Help:
        return new CommandHelp((CarrierHelp) carrier).execute();
      case Info:
        return new CommandInfo((CarrierInfo) carrier, collection).execute();
      case Insert:
        return new CommandInsert((CarrierInsert) carrier, collection).execute();
      case PrintAscending:
        return new CommandPrintAscending((CarrierPrintAscending) carrier, collection).execute();
      case PrintFieldDescendingMood:
        return new CommandPrintFieldDescendingMood((CarrierPrintFieldDescendingMood) carrier, collection).execute();
      case RemoveGreater:
        return new CommandRemoveGreater((CarrierRemoveGreater) carrier, collection).execute();
      case RemoveKey:
        return new CommandRemoveKey((CarrierRemoveKey) carrier, collection).execute();
      case RemoveLowerKey:
        return new CommandRemoveLowerKey((CarrierRemoveLowerKey) carrier, collection).execute();
      case ReplaceIfLower:
        return new CommandReplaceIfLower((CarrierReplaceIfLower) carrier, collection).execute();
      case Save:
        return new ServerResponse("Server side only command was sent");
      case Show:
        return new CommandShow((CarrierShow) carrier, collection).execute();
      case SumOfImpactSpeed:
        return new CommandSumOfImpactSpeed((CarrierSumOfImpactSpeed) carrier, collection).execute();
      case UpdateID:
        return new CommandUpdateID((CarrierUpdateID) carrier, collection).execute();
      default:
        return new ServerResponse("Command cannot be found");
    }
  }
}
