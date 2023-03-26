package commands;

import utils.Environment;
import utils.WrongScriptException;
import utils.XmlUtil;

public class Save implements ICommand {
    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        XmlUtil.saveXmlFile(environment);
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
