package commands;

import data.HumanBeing;
import utils.*;
import java.io.IOException;

public class Insert implements ICommand {

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        HumanBeing newHuman = new HumanBeing();

        Long id = 0L;

        try {
            id = EditUtil.keyParser(message, environment);
        } catch (NumberFormatException exception){
            environment.getPrintStream().println("Invalid Id");
            return;
        }
        catch (WrongIdException e) {
            environment.getPrintStream().println("No such element");
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
                if(environment.getPointer()>0){
                    throw new WrongScriptException();
                }
                environment.getPrintStream().println("The answer is 'yes' or 'no' ");
                if(i==2){
                    environment.getPrintStream().println("Command failed!");
                    return;
                }
                environment.getPrintStream().printf("You have %d attempts\n", 2-i);
            } catch (IOException exception) {
                if(environment.getPointer()>0){
                    throw new WrongScriptException();
                }
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
