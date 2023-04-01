package commands;

import managers.CollectionManager;
import utils.Environment;
import utils.WrongScriptException;

public class Clear implements ICommand{

    @Override
    public void execute(Environment environment, String message) {
        if(message.trim().length()>0){
            environment.getPrintStream().println("No arguments expected");
            return;
        }

        CollectionManager collectionManager = environment.getCollectionManager();
        collectionManager.clearAllPeople();
        System.out.println("Collection is cleared. Command finished successfully.");

    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear : очистить коллекцию";
    }
}
