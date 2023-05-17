package commands;

import java.io.Serializable;

public interface Carrier extends Serializable {
  public CommandIdentity identity();

  public String syntax();
}
