package commands;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;
import utils.BuilderException;
import utils.Environment;
import utils.WrongArgumentException;
import utils.WrongScriptException;
import validators.HumanBuilder;
import validators.Validator;

import java.util.List;

public class UpdateID implements ICommand {

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        // Переводим строку в число
        if(Validator.keyParser(environment, message)==null){
            return;
        }
        long id = Validator.keyParser(environment, message);
        if(environment.getCollectionManager().findById(id)==null){
            environment.getPrintStream().println("No such element \nCommand finished unsuccessfully!");
            return;
        }

        HumanBuilder humanBuilder = new HumanBuilder();
        HumanBeing human = null;
        try {
            human = humanBuilder.buildHuman(environment);
        } catch (BuilderException e) {
            return;
        }
        human.setId(id);
        environment.getCollectionManager().removeById(id);
        environment.getCollectionManager().addPerson(human);
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