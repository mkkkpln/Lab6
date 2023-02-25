package commands;

import utils.Environment;

public class SumOfImpactSpeed implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

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
