package com.tw.bibilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleDisplay {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Scanner scanner;

    public ConsoleDisplay(InputStream in, OutputStream out) {
        this.inputStream = in;
        this.outputStream = out;
        scanner = new Scanner(inputStream);
    }

    public void putOutput(Object object) {
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(object);
    }

    public int getInteger() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String getString() {
        String input = scanner.nextLine();
        return input;
    }
}
