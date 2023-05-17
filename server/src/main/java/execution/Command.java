package execution;

import data.ServerResponse;

public interface Command {
  public ServerResponse execute();

  public String name();
  public String description();
}
