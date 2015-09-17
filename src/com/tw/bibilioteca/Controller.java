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
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("Checkout Movies");
        }});
        return new MenuController(display, menu, libraryData);
    }
}
