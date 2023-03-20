package commands;

import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;
import utils.Environment;
import utils.WrongScriptException;

import java.util.*;

public class PrintFieldDescendingMood implements ICommand {
    private CollectionManager collectionManager;
    private HumanBeing human;
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        List<Mood> moodList = new ArrayList<>(List.of(Mood.values()));
        Collections.sort(moodList, new Comparator<Mood>() {
            @Override
            public int compare(Mood o1, Mood o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        for(int i = 0; i< moodList.size(); i++){
            for(HashMap.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
                if(entry.getValue().getMood().equals(moodList.get(i))){
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
