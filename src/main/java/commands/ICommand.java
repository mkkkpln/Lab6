package commands;

import utils.Environment;

public interface ICommand {
    void execute(Environment environment, String message);
    String getName();
    String getDescription();
}

