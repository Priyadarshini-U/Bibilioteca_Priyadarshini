package com.tw.bibilioteca;

public class MenuController implements IController{
    private ConsoleDisplay display;
    private Menu currentModel;
    private BibilioticaData libraryData;

    public MenuController(ConsoleDisplay display, Menu current, BibilioticaData libraryData) {
        this.currentModel = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public IController executeAction() {
        display.putOutput(currentModel);
        String choice = display.getString();
        if (choice.equals("1"))
            return new Controller(display, new EntityView(libraryData.getBookLibrary()), libraryData);
        if (choice.equals("5"))
            return new Controller(display, new EntityView(libraryData.getMoviesLibrary()), libraryData);
        if (choice.equals("3"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeCheckout();
        else if (choice.equals("4"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeReturn();
        else if (choice.equals("6"))
            new CatalogOperation(display, libraryData.getMoviesLibrary()).executeCheckout();
        else if (choice.equals("2"))
            return new ExitController();
        else
            display.putOutput("invalid option");
        return new MenuController(display, currentModel, libraryData);
    }
}
