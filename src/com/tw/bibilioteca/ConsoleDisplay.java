package com.tw.bibilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        }catch(Exception exception){
            scanner.nextLine();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("Enter Valid Number");
            return  getInteger();
        }
    }

    public String getString() {
        String input = scanner.nextLine();
        return input;
    }

    public String getLibraryNumber() {
        if(scanner.hasNext(Pattern.compile("...-....")))
            return  scanner.nextLine();
        else {
            scanner.nextLine();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("Enter Valid Library Number");
            return getLibraryNumber();
        }
    }
}
