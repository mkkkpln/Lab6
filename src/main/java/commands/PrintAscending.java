package commands;

import utils.Environment;

public class PrintAscending implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "printAscending";
    }

    @Override
    public String getDescription() {
        return "printAscending : вывести элементы коллекции в порядке возрастания";
    }
}
