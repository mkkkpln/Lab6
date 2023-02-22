package commands;

import utils.Environment;

public class SumOfImpactSpeed implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

    }

    @Override
    public String getName() {
        return "sum_of_impact_speed";
    }

    @Override
    public String getDescription() {
        return "sum_of_impact_speed : вывести сумму значений поля impactSpeed для всех элементов коллекции";
    }
}
