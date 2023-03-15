package commands;

import data.HumanBeing;
import managers.CollectionManager;
import utils.Environment;

import java.util.HashMap;

public class SumOfImpactSpeed implements ICommand {
    private CollectionManager collectionManager;
    @Override
    public void execute(Environment environment, String message) {

        float sum = 0;
        for (int i = 0; i < environment.getCollectionManager().getPeople().size(); i++) {
            sum += environment.getCollectionManager().getPeople().get(impactSpeed);
//            хочу обратиться к элементу хэшмапа people (impactSpeed)
        }

    }

    @Override
    public String getName() {
        return "sumOfImpactSpeed";
    }

    @Override
    public String getDescription() {
        return "sumOfImpactSpeed : вывести сумму значений поля impactSpeed для всех элементов коллекции";
    }
}
