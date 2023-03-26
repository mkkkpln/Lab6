package commands;

import data.HumanBeing;
import data.Mood;
import utils.Environment;
import utils.WrongScriptException;

import java.util.*;

public class PrintFieldDescendingMood implements ICommand {

    public PrintFieldDescendingMood() {
    }

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        List<Mood> moodList = new ArrayList<>(List.of(Mood.values()));
        moodList.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));

        for (Mood mood : moodList) {
            for (HashMap.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()) {
                if (entry.getValue().getMood().equals(mood)) {
                    environment.getPrintStream().println(entry.getValue().toString());
                }
            }
            environment.getPrintStream().println();
        }

        environment.getPrintStream().println("Command finished");
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
