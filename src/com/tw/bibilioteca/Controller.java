package com.tw.bibilioteca;

import java.util.ArrayList;

public class Controller implements IController{
    private ConsoleDisplay display;
    private Object current;
    private BibilioticaData libraryData;

    public Controller(ConsoleDisplay display, Object current, BibilioticaData libraryData) {
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
            add("5. List Movies");
            add("6. Checkout Movies");
        }});
        return new MenuController(display, menu, libraryData);
    }
}
