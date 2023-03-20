package commands;

import utils.Environment;

public class ReplaceIfLower implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "replaceIfLower";
    }

    @Override
    public String getDescription() {
        return "replaceIfLower null {element} : заменить значение по ключу, если новое значение меньше старого";
    }
}
