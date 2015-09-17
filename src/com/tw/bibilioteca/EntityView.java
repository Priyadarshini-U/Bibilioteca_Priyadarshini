package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class EntityView {
    private final int spacing = 20;
    private Catalog catalog;

    public EntityView(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return constructFromBookLibrary();
    }

    private String constructFromBookLibrary() {
        String displayString = "";
        displayString += columnHeaders();
        displayString += columnBuilders();
        return displayString;
    }

    private String columnBuilders() {
        String displayString = "";
        for (String bookName : catalog.getAvailableBooks().keySet()) {
            List<String> fieldValues = new ArrayList<String>();
            fieldValues.add(bookName);
            BookDetails bookDetails = catalog.getAvailableBooks().get(bookName);
            for (String words : bookDetails.toString().split("\\ "))
                fieldValues.add(words);
            displayString += formatList(fieldValues);
        }
        displayString += formatSeperator(catalog.fields().size());
        return displayString;
    }

    private String columnHeaders() {
        String displayString = "";
        displayString += formatList(catalog.fields());
        displayString += formatSeperator(catalog.fields().size());
        return displayString;
    }

    private String formatList(List<String> fields) {
        String displayString = "";
        for (String field : fields)
            displayString += String.format("%-" + spacing + "s", field);
        displayString += "\n";
        return displayString;
    }

    private String formatSeperator(int n) {
        String displayString = "";
        for (int i = 0; i < catalog.fields().size() * spacing; i++)
            displayString += "-";
        displayString += "\n";
        return displayString;
    }
}
