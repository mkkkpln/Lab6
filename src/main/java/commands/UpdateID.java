package commands;

import utils.Environment;

public class UpdateID implements ICommand {

    public UpdateID() {
    }

    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
