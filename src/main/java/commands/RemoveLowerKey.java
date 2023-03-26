package commands;

import data.HumanBeing;
import utils.Environment;
import utils.WrongScriptException;
import validators.Validator;

import java.util.HashMap;

public class RemoveLowerKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        if(Validator.keyParser(environment, message)==null){
            return;
        }
        long id = Validator.keyParser(environment, message);

        for (HashMap.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
            if(entry.getKey()<id){
                environment.getCollectionManager().removeById(entry.getKey());
            }
        }
        environment.getPrintStream().println("Command finished!");
    }

    @Override
    public String getName() {
        return "removeLowerKey";
    }

    @Override
    public String getDescription() {
        return "removeLowerKey null : удалить из коллекции все элементы, ключ которых меньше, чем заданный";
    }
}