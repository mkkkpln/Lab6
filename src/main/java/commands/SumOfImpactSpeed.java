package commands;

import data.HumanBeing;
import managers.CollectionManager;
import utils.Environment;
import java.util.Map;

public class SumOfImpactSpeed implements ICommand {
    @Override
    public void execute(Environment environment, String message) {

        double sum = 0;


        // after:
        for (Map.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
            sum += entry.getValue().getImpactSpeed();
        }

        environment.getPrintStream().printf("Общая скорость элементов коллекции равна : %.3f\n", sum);
        environment.getPrintStream().println("Команда завершена!");


        // before: sum += environment.getCollectionManager().getPeople().get(impactSpeed);
        // for (int i = 0; i < environment.getCollectionManager().getPeople().size(); i++) {
        //        sum += environment.getCollectionManager().getPeople().get(i).getImpactSpeed();

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
