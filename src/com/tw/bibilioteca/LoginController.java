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
        display.putOutput("Enter Password");
        String password = display.getString();
        String sessionToken = current.authenticate(libraryNumber, password);
        return null;
    }
}
