package commands;

import utils.Environment;

public class Show implements ICommand {
    @Override
    public void execute(Environment environment, String message) {
        if(environment.getCollectionManager().getPeople().size()>0){
            environment.getPrintStream().println(environment.getCollectionManager().toString());
        }
        else{
            environment.getPrintStream().println("Коллекция пуста!");
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
