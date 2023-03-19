package commands;

import managers.CollectionManager;
import utils.Environment;
import utils.WrongHeroException;
import utils.WrongScriptException;

import java.io.*;

public class ExecuteScript implements ICommand {
    private Invoker invoker;
    private String link;
    private FileInputStream fileInputStream;



    @Override
    public void execute(Environment environment, String message) {
        environment.setPointer(environment.getPointer()+1);
        link = message;
        invoker = new Invoker(environment, environment.getAllCommands());
        try{
            fileInputStream = new FileInputStream(link);
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
            environment.getPrintStream().println("File not found\n Command finished");
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

    @Override
    public String getName() {
        return "executeScript";
    }

    @Override
    public String getDescription() {
        return "executeScript fileName : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
