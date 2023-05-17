package Parsing;

import java.util.StringTokenizer;

import Parsing.exceptions.ParsingException;
import commands.Carrier;
import commands.CommandIdentity;

public final class CarrierParser {
  public final Carrier parse(final String inputLine) throws ParsingException {
    final StringTokenizer tokens = new StringTokenizer(inputLine, " ");
    if (!tokens.hasMoreTokens())
      throw new ParsingException("No command was given");
    final String command = tokens.nextToken();
    switch (command) {
      case "clear":
        return new CarrierFactory().build(CommandIdentity.Clear, tokens);
      case "exit":
        System.exit(0);
      case "help":
        return new CarrierFactory().build(CommandIdentity.Help, tokens);
      case "info":
        return new CarrierFactory().build(CommandIdentity.Info, tokens);
      case "insert":
        return new CarrierFactory().build(CommandIdentity.Insert, tokens);
      case "printAscending":
        return new CarrierFactory().build(CommandIdentity.PrintAscending, tokens);
      case "printFieldDescendingMood":
        return new CarrierFactory().build(CommandIdentity.PrintFieldDescendingMood, tokens);
      case "removeGreater":
        return new CarrierFactory().build(CommandIdentity.RemoveGreater, tokens);
      case "removeKey":
        return new CarrierFactory().build(CommandIdentity.RemoveKey, tokens);
      case "removeLowerKey":
        return new CarrierFactory().build(CommandIdentity.RemoveLowerKey, tokens);
      case "replaceIfLower":
        return new CarrierFactory().build(CommandIdentity.ReplaceIfLower, tokens);
      case "save":
        return new CarrierFactory().build(CommandIdentity.Save, tokens);
      case "show":
        return new CarrierFactory().build(CommandIdentity.Show, tokens);
      case "sumOfImpactSpeed":
        return new CarrierFactory().build(CommandIdentity.SumOfImpactSpeed, tokens);
      case "updateId":
        return new CarrierFactory().build(CommandIdentity.UpdateID, tokens);
      default:
        throw new ParsingException("Command not recognized");
    }
  }
}
