package commands;

import data.HumanBeing;
import managers.CollectionManager;
import utils.Environment;
import utils.WrongScriptException;

public class PrintFieldDescendingMood implements ICommand {
    private CollectionManager collectionManager;
    private HumanBeing human;
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        try{
            for (HumanBeing people : collectionManager.getPeople() ) {
                if (people.getMood().compareTo(people.getMood(),human.getMood())){
                    System.out.println(people.toString());
                }
            }
        }catch (Exception e){
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            System.out.println("Исключение!");
        }
    }

    @Override
    public String getName() {
        return "printFieldDescendingMood";
    }

    @Override
    public String getDescription() {
        return "printFieldDescendingMood : вывести значения поля mood всех элементов в порядке убывания";
    }
}
