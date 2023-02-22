package commands;

import utils.Environment;

public class Save implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл";
    }
}
