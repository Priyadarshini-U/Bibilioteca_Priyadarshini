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
            System.out.print(libraryData);
        if(optionChoice == 2)
            System.exit(0);
        if(optionChoice == 3){
            String bookName = display.getString();
            if(libraryData.isBookAvailableForCheckOut(bookName)) {
                libraryData.checkoutEntity(bookName);
                display.putOutput("checkout successful");
            }
            else
                display.putOutput("checkout NOT successful");
        }
        else
            System.out.print("Invalid Option");
    }
}
