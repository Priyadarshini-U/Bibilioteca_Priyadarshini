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

    public void choose(int optionChoice, Catalog libraryData){
        if(optionChoice == 1)
            System.out.print(libraryData);
        else
            System.out.print("Invalid Option");
    }
}
