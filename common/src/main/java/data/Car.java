package data;

import java.io.Serializable;

public final record Car(String name, boolean cool) implements Serializable {
}
