package com.tw.bibilioteca;

public class Controller implements IController {
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
        Menu menu = new Menu(new Users().getUserRole(libraryData.getSessionToken()).getDisplayOperations());
        return new MenuController(display, menu, libraryData);
    }
}
