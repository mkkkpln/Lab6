package commands;

import managers.CollectionManager;
import utils.Environment;

public class Info implements ICommand {

    @Override
    public void execute(Environment environment, String message) {
        System.out.println("Ниже представлена вся информация о коллекции:");
        CollectionManager collectionManager = environment.getCollectionManager();
        System.out.println("Тип коллекции: " + collectionManager.getClass() + ".");
        System.out.println("Дата инициализации коллекции: " + collectionManager.getCreationDate() + ".");
        System.out.println("Количество элементов: " + collectionManager.getPeople().size() + ".");
        System.out.println("Хранимые в коллекции элементы: \n " + collectionManager.getPeople().toString());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
