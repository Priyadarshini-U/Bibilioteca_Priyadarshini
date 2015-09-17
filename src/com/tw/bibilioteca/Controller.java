package com.tw.bibilioteca;

public class Controller {
    private ConsoleDisplay display;
    private Object current;
    private Catalog libraryData;

    public Controller(ConsoleDisplay display, Object current, Catalog libraryData) {
        this.current = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public Menu executeAction() {
        display.putOutput(current);
        return null;
    }
}
