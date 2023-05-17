package commands;

import data.HumanBeing;
import data.Mood;

public final record CarrierInsert(HumanBeing human) implements Carrier {
  @Override
  public CommandIdentity identity() {
    return CommandIdentity.Insert;
  }

  public String syntax() {
    return "insert name x y real toothpick impactSpeed soundtrack minutesOfWaiting mood car_name care_cool\n" +
        "Example: insert me 1.0 2 Yes No 11.0 CoolName 0.5 Sorrow Cart Yes\n" +
        "name: a string\n" +
        "x: real number\n" +
        "y: integer\n" +
        "real: whether is real: Yes or No\n" +
        "toothpick: whether has toothpick: Yes or No\n" +
        "impactSpeed: real\n" +
        "soundtrack: a string\n" +
        "minutes of waiting: real number\n" +
        "mood: one of: " + Mood.moods() +
        "car_name: name of the car\n" +
        "car_cool: whether car is cool: Yes or No\n";
  }
}
