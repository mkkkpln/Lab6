package commands;

import data.Car;
import data.HumanBeing;
import data.Mood;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReplaceIfLower implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        Long id;
        try {
            id = EditUtil.keyParser(message, environment);
        } catch (NumberFormatException exception){
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("Invalid Id");
            return;
        }
        catch (WrongIdException e) {
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("no such element");
            return;
        }

//
        HashMap<Long, HumanBeing> updatedMap = new HashMap<>();

        for (HashMap.Entry<Long, HumanBeing> entry : environment.getCollectionManager().getPeople().entrySet()){
            if(entry.getKey()>(id)){
                updatedMap.put(id, entry.getValue());
            } else {
                updatedMap.put(entry.getKey(), entry.getValue());
            }

            return;
            }
        environment.getPrintStream().println("Command finished!");

    }

    @Override
    public String getName() {
        return "replaceIfLower";
    }

    @Override
    public String getDescription() {
        return "replaceIfLower null {element} : заменить значение по ключу, если новое значение меньше старого";
    }
}
