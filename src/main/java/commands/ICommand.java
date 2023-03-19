package commands;

import utils.Environment;
import utils.WrongScriptException;

public interface ICommand {
    void execute(Environment environment, String message) throws WrongScriptException;
    String getName();
    String getDescription();
}

