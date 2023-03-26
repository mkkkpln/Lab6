package commands;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;
import utils.*;
import validators.HumanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Insert implements ICommand {

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        HumanBuilder humanBuilder = new HumanBuilder();
        HumanBeing human = humanBuilder.buildHuman(environment);
        environment.getCollectionManager().addPerson(human);
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insert : добавить новый элемент с заданным ключом";
    }
}
