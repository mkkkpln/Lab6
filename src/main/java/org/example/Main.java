package org.example;

import commands.*;
import managers.CollectionManager;
import utils.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CollectionManager manager = new CollectionManager();
        ArrayList<String> history = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream writer = new PrintStream(System.out);
        ICommand[] commands = new ICommand[]{new Help(), new Info(), new Exit(), new Clear(), new Show(), new Insert() };
        Environment environment = new Environment(manager, reader, writer, history, commands);
        Invoker invoker = new Invoker(environment, commands);

//        Invoker invoker = new Invoker(environment, new ICommand[]{});

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
            }
        }

    }
}