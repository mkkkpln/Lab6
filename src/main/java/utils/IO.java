package utils;

import commands.Invoker;

import java.io.*;

public class IO {
    public static void commandReader(Environment environment, Invoker invoker){
        BufferedReader reader = environment.getBufferedReader();
        System.out.println("Type 'help' to see commands");
        while(true){
            System.out.print("-> ");
            try {
                String userTyping = reader.readLine();
                invoker.executer(userTyping);
            }
            catch (IOException ex){
                System.out.println("Incorrect input");
            }
            catch (NullPointerException ex){
                System.out.println("No such command found");
            } catch (WrongScriptException ex) {
                System.out.println("Script failed");
            }
        }
    }
    public static void scriptReader(Environment environment,  String message){
        incPointer(environment);
        Invoker invoker = new Invoker(environment, environment.getAllCommands());
        try{
            FileInputStream fileInputStream = new FileInputStream(message);
            Reader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            environment.setBufferedReader(bufferedReader);
            String userLine = bufferedReader.readLine();
            while (!userLine.equals("EOF")){
                invoker.executer(userLine);
                userLine = bufferedReader.readLine();
            }
            environment.setPointer(environment.getPointer()-1);
            return;

        } catch (FileNotFoundException e) {
            environment.getPrintStream().println("File not found\nCommand finished");
            environment.setPointer(environment.getPointer()-1);
            return;
        } catch (IOException e) {
            environment.setPointer(environment.getPointer()-1);
            throw new RuntimeException(e);

        } catch (WrongScriptException e) {
            environment.getPrintStream().println("Your script has errors!");
            environment.setPointer(environment.getPointer()-1);
            return;
        }
    }

    public static void incPointer(Environment environment) {
        environment.setPointer(environment.getPointer()+1);
    }
}
