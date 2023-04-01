package commands;

import utils.Environment;

public class Exit implements ICommand{
    @Override
    public void execute(Environment environment, String message) {
        System.out.println("Program is finished.");
        System.exit(0);
        environment.getPrintStream().println("Command finished successfully!");
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
