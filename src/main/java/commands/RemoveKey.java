package commands;

import utils.Environment;

public class RemoveKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public String getDescription() {
        return "remove_key null : удалить элемент из коллекции по его ключу";
    }
}
