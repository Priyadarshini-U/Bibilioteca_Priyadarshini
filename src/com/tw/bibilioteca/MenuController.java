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
        String operation = currentModel.choose(display.getInteger());
        String choice = operation;
        if (choice.equals("Log in"))
            return new LoginController(display, new Login(), libraryData);
        if (choice.equals("List Books"))
            return new Controller(display, new EntityView(libraryData.getBookLibrary()), libraryData);
        if (choice.equals("List Movies"))
            return new Controller(display, new EntityView(libraryData.getMoviesLibrary()), libraryData);
        if (choice.equals("CheckOut Book"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeCheckout();
        else if (choice.equals("return Book"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeReturn();
        else if (choice.equals("CheckOut Movie"))
            new CatalogOperation(display, libraryData.getMoviesLibrary()).executeCheckout();
        else if (choice.equals("quit"))
            return new ExitController();
        else
            display.putOutput("invalid option");
        return new MenuController(display, currentModel, libraryData);
    }
}
