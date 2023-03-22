package commands;

import data.HumanBeing;
import utils.EditUtil;
import utils.Environment;
import utils.WrongIdException;
import utils.WrongScriptException;


public class RemoveKey implements ICommand {
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
