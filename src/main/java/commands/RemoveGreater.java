package commands;

import utils.Environment;

public class RemoveGreater implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
