package com.tw.bibilioteca;

public class MenuController implements IController{
    private ConsoleDisplay display;
    private Menu currentModel;
    private Catalog libraryData;

    public MenuController(ConsoleDisplay display, Menu current, Catalog libraryData) {
        this.currentModel = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public IController executeAction() {
        display.putOutput(currentModel);
        currentModel.choose(display.getInteger(), libraryData, display);
        return new MenuController(display, currentModel, libraryData);
    }
}
