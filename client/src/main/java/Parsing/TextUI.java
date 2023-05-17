package Parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class TextUI {
  final BufferedReader in;

  public TextUI() {
    in = new BufferedReader(new InputStreamReader(System.in));
  }

  public final void greeting() {
    System.out.println("Введите 'help' чтобы узнать список доступных команд.");
    System.out.println("Введите 'exit' чтобы выйти.");
  }

  public final String readLine() throws IOException {
    return in.readLine();
  }
}
