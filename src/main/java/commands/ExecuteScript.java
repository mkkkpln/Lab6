package commands;

import managers.CollectionManager;
import utils.Environment;

public class ExecuteScript implements ICommand {


    @Override
    public void execute(Environment environment, String message) {

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
