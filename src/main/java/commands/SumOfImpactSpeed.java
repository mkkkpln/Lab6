package commands;

import data.HumanBeing;
import utils.Environment;

import java.util.Map;

public class SumOfImpactSpeed implements ICommand {
    @Override
    public void execute(Environment environment, String message) {
        double sum = 0;
        for (Map.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
            sum += entry.getValue().getImpactSpeed();
        }
        environment.getPrintStream().printf("Sum of impact speed is : %.3f\n", sum);
        environment.getPrintStream().println("Command finished successfully!");
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