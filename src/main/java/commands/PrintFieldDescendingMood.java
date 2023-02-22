package commands;

import utils.Environment;

public class PrintFieldDescendingMood implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "print_field_descending_mood";
    }

    @Override
    public String getDescription() {
        return "print_field_descending_mood : вывести значения поля mood всех элементов в порядке убывания";
    }
}
