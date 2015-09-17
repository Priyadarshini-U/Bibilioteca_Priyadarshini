package com.tw.bibilioteca;

public class LoginController implements IController {
    private ConsoleDisplay display;
    private Login current;
    private BibilioticaData libraryData;

    public LoginController(ConsoleDisplay display, Login current, BibilioticaData libraryData) {
        this.current = current;
        this.display = display;
        this.libraryData = libraryData;
    }

    @Override
    public IController executeAction() {
        display.putOutput("Enter library Number");
        String libraryNumber = display.getString();
        return null;
    }
}
