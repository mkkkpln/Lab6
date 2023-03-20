package commands;

import utils.Environment;
import utils.WrongScriptException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Save implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        OutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(environment.getBufferedReader().readLine());
            JAXBContext jaxbContext = JAXBContext.newInstance(environment.getCollectionManager().getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(environment.getCollectionManager(),fileOutputStream);
            System.out.println("Файл сохранен");
        } catch (IOException e){
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("File not found");

        } catch (PropertyException e) {
            if(environment.getPointer()>0){
                throw new WrongScriptException();
            }
            environment.getPrintStream().println("No property!");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл";
    }
}
