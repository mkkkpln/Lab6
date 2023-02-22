package commands;

import utils.Environment;

public class ReplaceIfLowe implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "replace_if_lowe";
    }

    @Override
    public String getDescription() {
        return "replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого";
    }
}
