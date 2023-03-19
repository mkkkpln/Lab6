package commands;

import data.HumanBeing;
import utils.EditUtil;
import utils.Environment;
import utils.WrongIdException;
import utils.WrongScriptException;

import java.util.HashMap;

public class RemoveLowerKey implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        Long id;
        try {
            id = EditUtil.keyParser(message, environment);
        } catch (NumberFormatException exception){
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("Invalid Id");
            return;
        }
        catch (WrongIdException e) {
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("no such element");
            return;
        }

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
