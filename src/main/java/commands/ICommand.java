package commands;

import utils.Environment;
import utils.NoSuchCommandException;
import utils.WrongScriptException;

public interface ICommand {

    void execute(Environment environment, String message) throws WrongScriptException, NoSuchCommandException;
    String getName();
    String getDescription();
}

