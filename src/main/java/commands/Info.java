package commands;

import managers.CollectionManager;
import utils.Environment;

public class Info implements ICommand {
    private CollectionManager collectionManager;
    public Info() {
    }

    @Override
    public void execute(Environment environment, String message) {
        System.out.println("Ниже представлена вся информация о коллекции:");
        collectionManager = environment.getCollectionManager();
        System.out.println("Тип коллекции: " + this.collectionManager.getClass() + ".");
        System.out.println("Дата инициализации коллекции: ");
        System.out.println("Количество элементов: " );
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
