package commands;

import utils.Environment;


public class Help implements ICommand{
    private Invoker invoker;

    public Help(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void execute(Environment environment, String message) {
        for (ICommand s : invoker.getCommandHashMap().values()) {
            System.out.println(s.getDescription());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }
}
