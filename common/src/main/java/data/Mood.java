package data;

import java.util.Optional;

public enum Mood {
  SORROW,
  GLOOM,
  APATHY,
  CALM;

  public static Optional<Mood> parse(final String input) {
    if (input.equalsIgnoreCase(SORROW.name()))
      return Optional.of(SORROW);
    else if (input.equalsIgnoreCase(GLOOM.name()))
      return Optional.of(GLOOM);
    else if (input.equalsIgnoreCase(APATHY.name()))
      return Optional.of(APATHY);
    else if (input.equalsIgnoreCase(CALM.name()))
      return Optional.of(CALM);
    else
      return Optional.empty();
  }

  public static String moods() {
    return Mood.SORROW.toString() + "," +
        Mood.CALM.toString() + "," +
        Mood.GLOOM.toString() + "," +
        Mood.APATHY.toString();
  }
}
