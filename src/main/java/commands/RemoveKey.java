package commands;

import utils.Environment;

public class RemoveKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "removeKey";
    }

    @Override
    public String getDescription() {
        return "removeKey null : удалить элемент из коллекции по его ключу";
    }
}
