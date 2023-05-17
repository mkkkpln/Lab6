package data;

import java.io.Serializable;
import java.time.Instant;

public final record HumanBeing(
    String name,
    Coordinates coordinates,
    boolean realHero,
    boolean hasToothpick,
    float impactSpeed,
    String soundtrackName,
    float minutesOfWaiting,
    Mood mood,
    Car car,
    Instant creationDate) implements Serializable {

  public HumanBeing(
      final String name,
      final Coordinates coordinates,
      final boolean realHero,
      final boolean hasToothpick,
      final float impactSpeed,
      final String soundtrackName,
      final float minutesOfWaiting,
      final Mood mood,
      final Car car) {
    this(name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, mood, car,
        Instant.now());
  }
}
