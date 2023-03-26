package commands;

import data.HumanBeing;
import utils.*;
import validators.Validator;

import java.util.HashMap;

public class ReplaceIfLower implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        if(Validator.keyParser(environment, message)==null){
            return;
        }
        long id = Validator.keyParser(environment, message);

        HashMap<Long, HumanBeing> updatedMap = new HashMap<>();

        for (HashMap.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
            if(entry.getKey()>(id)){
                updatedMap.put(id, entry.getValue());
            } else {
                updatedMap.put(entry.getKey(), entry.getValue());
            }
            return;
        }
        environment.getPrintStream().println("Command finished!");

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
