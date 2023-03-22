package org.example;

import commands.*;
import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;
import org.xml.sax.SAXException;
import utils.EditUtil;
import utils.Environment;
import utils.WrongScriptException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CollectionManager manager = new CollectionManager();

        //Загрузим коллекцию из файла
        String link = "meme.xml";

        try {
            manager = EditUtil.XMLParser(link);
        } catch (ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


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




        ArrayList<String> history = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream writer = new PrintStream(System.out);
        ICommand[] commands = new ICommand[]{new Help(), new Info(), new Exit(), new Clear(), new Show(), new Insert(), new SumOfImpactSpeed(), new RemoveKey(), new RemoveGreater(), new ReplaceIfLower(), new ExecuteScript(), new PrintFieldDescendingMood(), new Save(), new UpdateID(), new PrintAscending()};
        Environment environment = new Environment(manager, reader, writer, history, commands);
        Invoker invoker = new Invoker(environment, commands);


        System.out.println("Type 'help' to see commands");
        while(true){
            try {
                String userTyping = reader.readLine();
                invoker.executer(userTyping);
                history.add(userTyping.split(" ")[0]);
            }
            catch (IOException ex){
                System.out.println("Incorrect input");
            }
            catch (NullPointerException exe){
                System.out.println("No such command found");
            } catch (WrongScriptException e) {
                System.out.println("Script failed");
            }
        }

    }
}