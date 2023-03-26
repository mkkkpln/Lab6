package commands;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;
import utils.Environment;
import utils.WrongArgumentException;
import utils.WrongScriptException;
import validators.Validator;

import java.util.List;

public class UpdateID implements ICommand {

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        // Переводим строку в число
        if(Validator.keyParser(environment, message)==null){
            return;
        }
        long id = Validator.keyParser(environment, message);
        if(environment.getCollectionManager().findById(id)==null){
            environment.getPrintStream().println("No such element\nCommand finished!");
            return;
        }
        // Находим нужный объект из коллекции
        HumanBeing newHuman = environment.getCollectionManager().findById(id);



        environment.getPrintStream().println("Enter the name");
        try {
            newHuman.setName(Validator.nameParser(environment));
        } catch (WrongArgumentException e) {
            // или не находим и выходим из команды
            return;
        }


        // Он герой??
        environment.getPrintStream().println("Is he a hero? type: 'yes' or 'no'");
        boolean isHero = false;
        try {
            newHuman.setRealHero(Validator.parseBoolWithChecks(environment));
        } catch (WrongArgumentException e) {
            return;
        }


        //Устанавливаем настроение
        environment.getPrintStream().println("Set Mood");
        System.out.println(List.of(Mood.values()));
        try {
            newHuman.setMood(Validator.moodParser(environment));
        } catch (WrongArgumentException e) {
            return;
        }


        float x = 0f;
        int y = 0;
        //Запрашиваем координаты
        environment.getPrintStream().println("Enter Float x");
        try {
            x = Validator.floatParser(environment);
        } catch (WrongArgumentException e) {
            return;
        }
        environment.getPrintStream().println("Enter Integer y");
        try {
            y = Validator.integerParser(environment);
        } catch (WrongArgumentException e) {
            return;
        }
        newHuman.setCoordinates(new Coordinates(x,y));


        //Есть ли зубочистка?
        environment.getPrintStream().println("Does he have a toothpick?? type:'yes' or 'no'");

        try {
            newHuman.setHasToothpick(Validator.parseBoolWithChecks(environment));
        } catch (WrongArgumentException e) {
            return;
        }



        //Устанавливаем скорость
        environment.getPrintStream().println("Enter float speed");
        try {
            newHuman.setImpactSpeed(Validator.floatParser(environment));
        } catch (WrongArgumentException e) {
            return;
        }


        //Устанавливаем время ожидания
        environment.getPrintStream().println("Enter minutes of waiting (float)");

        try {
            newHuman.setMinutesOfWaiting(Validator.floatParser(environment));
        } catch (WrongArgumentException e) {
            return;
        }


        //Устанавливаем саундтрек
        environment.getPrintStream().println("Enter the sondtrack name");
        try {
            newHuman.setSoundtrackName(Validator.liteNameParser(environment));
        } catch (WrongArgumentException e) {
            return;
        }


        //Создаем машину
        environment.getPrintStream().println("Create a Car!!!!!");
        Car car = new Car();
        boolean isCool = false;


        environment.getPrintStream().println("Is it Cool???? 'yes' or 'no'");
        try {
            isCool = Validator.parseBoolWithChecks(environment);
        } catch (WrongArgumentException e) {
            return;
        }

        environment.getPrintStream().println("type the name!");
        String carName = "";
        try {
            carName = Validator.liteNameParser(environment);
        } catch (WrongArgumentException e) {
            return;
        }


        car.setName(carName);
        car.setCool(isCool);
        newHuman.setCar(car);
        environment.getPrintStream().println("Command finished");


    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
