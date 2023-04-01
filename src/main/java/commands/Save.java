package commands;

import utils.Environment;
import utils.WrongScriptException;
import utils.XmlUtil;

public class Save implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {

        if (XmlUtil.saveXmlFile(environment)) {
           environment.getPrintStream().println("Collection is saved. Command finished successfully.");
           }
        else {
            environment.getPrintStream().println("Collection is not saved. Command finished unsuccessfully");
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
