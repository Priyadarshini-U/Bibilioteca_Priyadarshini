package com.tw.bibilioteca;

import java.util.List;

public class Menu {
    private List<String> options;

    public Menu(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return options.toString();
    }

    public void choose(int optionChoice, Catalog libraryData, ConsoleDisplay display){
        if(optionChoice == 1)
            display.putOutput(libraryData);
        else if(optionChoice == 2)
            System.exit(0);
        else if(optionChoice == 3)
            new CatalogOperation(display, libraryData).executeCheckout();
        else if(optionChoice == 4)
            new CatalogOperation(display, libraryData).executeReturn();
        else
            display.putOutput("Invalid Option");
    }
}
