package commands;

import utils.Environment;
import utils.WrongScriptException;
import validators.Validator;


public class RemoveKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        if(Validator.keyParser(environment, message)==null){
            return;
        }
        long id = Validator.keyParser(environment, message);
        environment.getCollectionManager().removeById(id);
        environment.getPrintStream().println("Command finished!");

    }

    @Override
    public String getName() {
        return "removeKey";
    }

    @Override
    public String getDescription() {
        return "removeKey null : удалить элемент из коллекции по его ключу";
    }
}