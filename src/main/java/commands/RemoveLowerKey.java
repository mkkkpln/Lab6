package commands;

import utils.Environment;

public class RemoveLowerKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    @Override
    public String getDescription() {
        return "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный";
    }
}
