package commands;

import utils.Environment;

public class Exit implements ICommand{
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
