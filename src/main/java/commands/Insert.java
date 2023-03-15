package commands;

import data.HumanBeing;
import utils.EditUtil;
import utils.Environment;
import utils.WrongHeroException;
import utils.WrongIdException;

import java.io.IOException;

public class Insert implements ICommand {

    @Override
    public void execute(Environment environment, String message) {
        HumanBeing newHuman = new HumanBeing();

        Long id = 0L;

        try {
            id = EditUtil.keyParser(message, environment);
        } catch (WrongIdException e) {
            environment.getPrintStream().println("Invalid Id");
            return;
        }
        newHuman.setId(id);


        environment.getPrintStream().println("Is he a hero? type: \'yes\' or \'no\'");
        boolean isHero = false;

        for (int i = 0; i < 3; i++) {
            try {
                isHero = EditUtil.realHeroParser(environment.getBufferedReader().readLine());
                break;
            } catch (WrongHeroException e) {
                environment.getPrintStream().println("The answer is 'yes' or 'no' ");
                if(i==2){
                    environment.getPrintStream().println("Command failed!");
                    return;
                }
                environment.getPrintStream().printf("You have %d attempts\n", 2-i);
            } catch (IOException exception) {
                environment.getPrintStream().println("Invalid input");
                environment.getPrintStream().println("Command finished!!!");
                if(i==2){
                    environment.getPrintStream().println("Command failed!");
                    return;
                }
            }
        }
        newHuman.setRealHero(isHero);

        environment.getPrintStream().println(newHuman.getId());
        environment.getPrintStream().println(newHuman.getRealHero());

    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}
