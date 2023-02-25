package commands;

import utils.Environment;

public class RemoveLowerKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "removeLowerKey";
    }

    @Override
    public String getDescription() {
        return "removeLowerKey null : удалить из коллекции все элементы, ключ которых меньше, чем заданный";
    }
}
