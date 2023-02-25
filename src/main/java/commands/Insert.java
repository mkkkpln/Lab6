package commands;

import data.HumanBeing;
import managers.CollectionManager;
import utils.Environment;

import java.util.HashMap;

public class Insert implements ICommand {

    private Invoker invoker;
    private CollectionManager collectionManager;
    private String newKey;
    private int intNewKey;
    private HashMap<Integer, HumanBeing> human;

    public Insert(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void execute(Environment environment, String message) {
        collectionManager = environment.getCollectionManager();
        newKey = message;
        intNewKey = Integer.parseInt(newKey);
        // ниже 4 варианта, как я хочу добавить ключ к объекту HumanBeing, у которого есть только id

        //this.collectionManager.human.put(intNewKey ); // как обратиться к коллекции людей через collectionManager
        //this.collectionManager.setHuman(intNewKey, );
        //this.collectionManager.getHuman().put(intNewKey);
        //HumanBeing humanBeing = new HumanBeing()
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}
