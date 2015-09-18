package com.tw.bibilioteca;

import java.util.HashMap;

public class MenuController implements IController {
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
        String choice = currentModel.choose(display.getInteger());
        final String session = libraryData.getSessionToken();
        Catalog bookLibrary = libraryData.getBookLibrary();
        Catalog movieLibrary = libraryData.getMoviesLibrary();

        if (!isValidOperationForCurrentUser(choice, session))
            return new LoginController(display, new Login(), libraryData);
        if (choice.equals("Log in"))
            return new LoginController(display, new Login(), libraryData);
        if (choice.equals("Log out"))
            return new MenuController(display, new Menu(UserRole.GUEST.getDisplayOperations()), new BibilioticaData(bookLibrary, movieLibrary, new GuestUser().authenticate()));
        if (choice.equals("List Books"))
            return new Controller(display, new EntityView(bookLibrary), libraryData);
        if (choice.equals("List Movies"))
            return new Controller(display, new EntityView(movieLibrary), libraryData);
        if (choice.equals("CheckOut Book"))
            new CatalogOperation(display, bookLibrary).executeCheckout(new Users().getUserLibraryNumber(session));
        else if (choice.equals("return Book"))
            new CatalogOperation(display, bookLibrary).executeReturn(new Users().getUserLibraryNumber(session));
        else if (choice.equals("CheckOut Movie"))
            new CatalogOperation(display, movieLibrary).executeCheckout(new Users().getUserLibraryNumber(session));
        else if (choice.equals("quit"))
            return new ExitController();
        else if (choice.equals("Book Status")) {
            Catalog catalogDisplay = new Catalog(bookLibrary.getCheckedOutEntities(), bookLibrary.getAvailableEntities());
            return new Controller(display, new EntityView(catalogDisplay), libraryData);
        } else if (choice.equals("User Information")) {
            final Catalog catalogDisplay = new Catalog(new HashMap<String, EntityDetails>() {{
                put("", new Users().getUserInformationFromToken(session));
            }}, bookLibrary.getAvailableEntities() );
            return new Controller(display, new EntityView(catalogDisplay), libraryData);
        } else
            display.putOutput("invalid option");
        return new MenuController(display, currentModel, libraryData);
    }

    private boolean isValidOperationForCurrentUser(String choice, String sessionToken) {
        return new Users().getUserRole(sessionToken).getOperations().contains(choice);
    }
}
