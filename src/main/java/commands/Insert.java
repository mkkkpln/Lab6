package commands;

import utils.Environment;

public class Insert implements ICommand {

    public Insert() {
    }

    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}
