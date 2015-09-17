package com.tw.bibilioteca;

public class MenuController {
    private ConsoleDisplay display;
    private Menu currentModel;
    private Catalog libraryData;

    public MenuController(ConsoleDisplay display, Menu current, Catalog libraryData) {
        this.currentModel = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public MenuController executeAction() {
        return new MenuController(display, currentModel, libraryData);
    }
}
