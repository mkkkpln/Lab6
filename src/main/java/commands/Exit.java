package commands;

import managers.CollectionManager;
import utils.Environment;

public class Exit implements ICommand{
    private CollectionManager collectionManager;
    @Override
    public void execute(Environment environment, String message) {
        System.out.println("Программа завершена.");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
