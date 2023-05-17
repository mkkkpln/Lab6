package data;

import java.io.Serializable;
import java.util.NavigableMap;
import java.util.TreeMap;

public final record CollectionManager(NavigableMap<Long, HumanBeing> data) implements Serializable {
  public CollectionManager() {
    this(new TreeMap<Long, HumanBeing>());
  }
}
