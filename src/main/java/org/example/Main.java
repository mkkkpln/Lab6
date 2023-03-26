package org.example;

import commands.*;
import managers.CollectionManager;
import org.xml.sax.SAXException;
import utils.XmlUtil;
import utils.Environment;
import utils.IO;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        CollectionManager manager;

        //Загрузим коллекцию из файла
        String link = "meme.xml";
        manager = XmlUtil.XMLParser(link);

        /*
        // А давайте еще один элемент коллекции создадим, но руками. Для эксперимента.
        Car car = new Car();
        car.setName("Chevrolet Chevelle Malibu");
        car.setCool(true);
        HumanBeing realHumanBeing = new HumanBeing();
        Long id = 1L;
        realHumanBeing.setId(id);
        realHumanBeing.setRealHero(true);
        realHumanBeing.setName("Ryan Gosling");
        realHumanBeing.setCar(car);
        realHumanBeing.setCoordinates(new Coordinates(0f, 0));
        realHumanBeing.setHasToothpick(true);
        realHumanBeing.setMinutesOfWaiting(5f);
        realHumanBeing.setImpactSpeed(186f);
        realHumanBeing.setMood(Mood.CALM);
        realHumanBeing.setSoundtrackName("NightCall");
        realHumanBeing.setCreationDate(LocalDate.parse("1980-10-12"));
        manager.addPerson(realHumanBeing);
*/


        //Генерируем все необходимое для паттерна "Command"
        ArrayList<String> history = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream writer = new PrintStream(System.out);
        ICommand[] commands = new ICommand[]{new Help(), new Info(), new Exit(), new Clear(), new Show(), new Insert(), new SumOfImpactSpeed(), new RemoveKey(), new RemoveGreater(), new ReplaceIfLower(), new ExecuteScript(), new PrintFieldDescendingMood(), new Save(), new UpdateID(), new PrintAscending(), new RemoveLowerKey()};
        Environment environment = new Environment(manager, reader, writer, history, commands);
        Invoker invoker = new Invoker(environment, commands);

        //запускаем программу
        IO.commandReader(environment, invoker);


    }
}