package commands;

import utils.Environment;

public class PrintAscending implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "print_ascending";
    }

    @Override
    public String getDescription() {
        return "print_ascending : вывести элементы коллекции в порядке возрастания";
    }
}
