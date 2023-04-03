package org.example;

import commands.*;
import managers.CollectionManager;
import org.xml.sax.SAXException;
import utils.*;
import utils.IO;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CollectionManager manager;

        //Загрузим коллекцию из файла
        if (args.length > 0) {
            String link = args[0];

            try {
                manager = XmlUtil.XMLParser(link);

                //Генерируем все необходимое для паттерна "Command"
                ArrayList<String> history = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintStream writer = new PrintStream(System.out);
                ICommand[] commands = new ICommand[]{new Help(), new Info(), new Exit(), new Clear(), new Show(), new Insert(), new SumOfImpactSpeed(), new RemoveKey(), new RemoveGreater(), new ReplaceIfLower(), new ExecuteScript(), new PrintFieldDescendingMood(), new Save(), new UpdateID(), new PrintAscending(), new RemoveLowerKey()};
                Environment environment = new Environment(manager, reader, writer, history, commands);
                Invoker invoker = new Invoker(environment, commands);

                //запускаем программу
                IO.commandReader(environment, invoker);

            } catch (ParserConfigurationException | IOException e) {
                System.err.println("ParserConfigurationException or IOException caught...");
                e.printStackTrace();
            } catch (SAXException e) {
                System.err.println("SAXException caught...");
                e.printStackTrace();
            }
        }

    }
}