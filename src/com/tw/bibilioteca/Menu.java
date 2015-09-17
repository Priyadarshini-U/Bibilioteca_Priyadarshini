package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> listOptions;

    public Menu(List<String> listOptions) {
        this.listOptions = new ArrayList<String>();
        this.listOptions = listOptions;

    }

    @Override
    public String toString() {
        int index = 0;
        String result = "";
        for (String first : listOptions) {
            result += ++index + ". " + first + " ";
        }
        return result + "\n";
    }

    public String choose(int option) {
        return listOptions.get(option-1);
    }
}
