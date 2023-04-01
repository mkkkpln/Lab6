package commands;

import utils.Environment;
import utils.IO;
import utils.WrongScriptException;

import java.io.*;

public class ExecuteScript implements ICommand {


    @Override
    public void execute(Environment environment, String message) {
        IO.scriptReader(environment, message);
        environment.getPrintStream().println("Command finished successfully!");
    }

    @Override
    public String getName() {
        return "executeScript";
    }

    @Override
    public String getDescription() {
        return "executeScript fileName : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
