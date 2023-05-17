package execution.commands;

import java.io.IOException;
import java.nio.file.Path;

import data.PersistenceManager;
import data.ServerResponse;
import execution.Command;

public final class CommandSave implements Command {
  private final PersistenceManager collection;
  private final Path file;

  public CommandSave(final PersistenceManager collection, final Path file) {
    this.collection = collection;
    this.file = file;
  }

  public ServerResponse execute() {
    try {
      collection.save(file);
      return new ServerResponse("File saved");
    } catch (IOException e) {
      return new ServerResponse("Server failed to save the file");
    }
  }

  public String name() {
    return "save";
  }

  public String description() {
    return this.name() + " : saves the collection";
  }
}
