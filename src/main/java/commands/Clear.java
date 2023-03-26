package commands;

import managers.CollectionManager;
import utils.Environment;

public class Clear implements ICommand{

    @Override
    public void execute(Environment environment, String message) {
        CollectionManager collectionManager = environment.getCollectionManager();
        collectionManager.clearAllPeople();
        System.out.println("Collection is cleared.");

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
