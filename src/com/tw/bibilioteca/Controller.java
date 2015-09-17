package com.tw.bibilioteca;

import java.util.ArrayList;

public class Controller implements IController{
    private ConsoleDisplay display;
    private Object current;
    private Catalog libraryData;

    public Controller(ConsoleDisplay display, Object current, Catalog libraryData) {
        this.current = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public IController executeAction() {
        display.putOutput(current);
        Menu menu = new Menu(new ArrayList<String>() {{
            add("1. List Books");
            add("2. quit");
            add("3. Checkout Book");
            add("4. Return Book");
        }});
        return new MenuController(display, menu, libraryData);
    }
}
