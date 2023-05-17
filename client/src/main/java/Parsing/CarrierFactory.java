package Parsing;

import java.util.Optional;
import java.util.StringTokenizer;

import Parsing.exceptions.ParsingException;
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
import commands.CommandIdentity;
import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;

public final class CarrierFactory {
  public final Carrier build(final CommandIdentity identity, final StringTokenizer tokens) throws ParsingException {
    switch (identity) {
      case Clear:
        return new CarrierClear();
      case Help:
        return new CarrierHelp();
      case Info:
        return new CarrierInfo();
      case Insert:
        return new CarrierInsert(humanParse(tokens));
      case PrintAscending:
        return new CarrierPrintAscending();
      case PrintFieldDescendingMood:
        return new CarrierPrintFieldDescendingMood();
      case RemoveGreater:
        return new CarrierRemoveGreater(parseLong(tokens, new CarrierRemoveGreater(0).syntax()));
      case RemoveKey:
        return new CarrierRemoveKey(parseLong(tokens, new CarrierRemoveKey(0).syntax()));
      case RemoveLowerKey:
        return new CarrierRemoveLowerKey(parseLong(tokens, new CarrierRemoveLowerKey(0).syntax()));
      case ReplaceIfLower:
        return new CarrierReplaceIfLower(parseLong(tokens, new CarrierReplaceIfLower(0, null).syntax()),
            humanParse(tokens));
      case Show:
        return new CarrierShow();
      case SumOfImpactSpeed:
        return new CarrierSumOfImpactSpeed();
      case UpdateID:
        return new CarrierUpdateID(parseLong(tokens, new CarrierUpdateID(0, null).syntax()),
            humanParse(tokens));
      default:
        throw new ParsingException("Command does not exist");
    }
  }

  private HumanBeing humanParse(StringTokenizer tokens) throws ParsingException {
    if (tokens.countTokens() != 11) {
      throw new ParsingException(
          "Invalid syntax for command insert\n" +
              "Appropriate syntax: " +
              new CarrierInsert(null).syntax());
    }
    final String name = tokens.nextToken();
    final Coordinates coords = new Coordinates(
        Float.parseFloat(tokens.nextToken()),
        Integer.parseInt(tokens.nextToken()));
    final boolean isHero = parseBoolean(tokens.nextToken());
    final boolean toothpick = parseBoolean(tokens.nextToken());
    final float speedOfImpact = Float.parseFloat(tokens.nextToken());
    final String soundtrackName = tokens.nextToken();
    final float minutesOfWaiting = Float.parseFloat(tokens.nextToken());
    final Optional<Mood> mood = Mood.parse(tokens.nextToken());
    if (mood.isEmpty())
      throw new ParsingException("Mood incorrect");
    final Car car = new Car(tokens.nextToken(), parseBoolean(tokens.nextToken()));
    return new HumanBeing(
        name,
        coords,
        isHero,
        toothpick,
        speedOfImpact,
        soundtrackName,
        minutesOfWaiting,
        mood.get(), car);
  }

  private long parseLong(final StringTokenizer tokens, final String correctSyntax) throws ParsingException {
    if (!tokens.hasMoreTokens()) {
      throw new ParsingException("Invalid syntax, correct syntax:\n" + correctSyntax);
    }
    try {
      return Long.parseLong(tokens.nextToken());
    } catch (NumberFormatException exception) {
      throw new ParsingException("id was not an integer, correct syntax\n" + correctSyntax);
    }
  }

  private boolean parseBoolean(String input) throws ParsingException {
    if (input.length() < 1) {
      throw new ParsingException("One of the booleans was a zero-length string");
    }
    switch (input.codePointAt(0)) {
      case 'Y':
      case 'y':
      case '1':
        return true;
      case 'n':
      case 'N':
      case '0':
        return false;
      default:
        throw new ParsingException("One of the booleans was not a Yes or No");
    }
  }
}
