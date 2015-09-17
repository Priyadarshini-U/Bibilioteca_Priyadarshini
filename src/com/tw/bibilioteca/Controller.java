package com.tw.bibilioteca;

import java.util.ArrayList;

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
        return new Menu(new ArrayList<String>() {{
            add("1. List Books");
        }});
    }
}
