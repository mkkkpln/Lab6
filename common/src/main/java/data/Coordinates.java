package data;

import java.io.Serializable;

public final record Coordinates(float x, int y) implements Serializable {
  public final Coordinates validateAndConstruct(final float x, final int y) throws IllegalArgumentException {
    if (x <= 598)
      throw new IllegalArgumentException("The x value must be greater than -598");
    if (y <= 67)
      throw new IllegalArgumentException("The y value must be greater than -67");
    return new Coordinates(x, y);
  }
}
