package data;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


// сохраняет и загружает файл, в котором хранится коллекция
public final record PersistenceManager(CollectionManager collection) {
  public PersistenceManager() {
    this(new CollectionManager());
  }

  public void save(final Path file) throws FileNotFoundException, IOException {
    try (final ObjectOutputStream out = new ObjectOutputStream(
        Files.newOutputStream(file,
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING))) {
      out.writeObject(this.collection());
    }
  }

  public PersistenceManager load(final Path file) {
    try (final ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file)))) {
      return new PersistenceManager((CollectionManager) in.readObject());
    } catch (ClassNotFoundException e) {
      return new PersistenceManager();
    } catch (IOException e) {
      return new PersistenceManager();
    }
  }
}
