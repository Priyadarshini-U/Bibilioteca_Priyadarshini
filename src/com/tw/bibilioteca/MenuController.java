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
        if (!isValidOperationForCurrentUser(choice, libraryData.getSessionToken()))
            return new LoginController(display, new Login(), libraryData);
        if (choice.equals("Log in"))
            return new LoginController(display, new Login(), libraryData);
        if (choice.equals("Log out"))
            return new MenuController(display, new Menu(UserRole.GUEST.getDisplayOperations()), new BibilioticaData(libraryData.getBookLibrary(), libraryData.getMoviesLibrary(), new GuestUser().authenticate()));
        if (choice.equals("List Books"))
            return new Controller(display, new EntityView(libraryData.getBookLibrary()), libraryData);
        if (choice.equals("List Movies"))
            return new Controller(display, new EntityView(libraryData.getMoviesLibrary()), libraryData);
        if (choice.equals("CheckOut Book"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeCheckout(new Users().getUserLibraryNumber(libraryData.getSessionToken()));
        else if (choice.equals("return Book"))
            new CatalogOperation(display, libraryData.getBookLibrary()).executeReturn(new Users().getUserLibraryNumber(libraryData.getSessionToken()));
        else if (choice.equals("CheckOut Movie"))
            new CatalogOperation(display, libraryData.getMoviesLibrary()).executeCheckout(new Users().getUserLibraryNumber(libraryData.getSessionToken()));
        else if (choice.equals("quit"))
            return new ExitController();
        else if (choice.equals("Book Status")) {
            Catalog catalogDisplay = new Catalog(libraryData.getBookLibrary().getCheckedOutEntities(), null);
            return new Controller(display, new EntityView(catalogDisplay), libraryData);
        }
        else
            display.putOutput("invalid option");
        return new MenuController(display, currentModel, libraryData);
    }

    private boolean isValidOperationForCurrentUser(String choice, String sessionToken) {
        return new Users().getUserRole(sessionToken).getOperations().contains(choice);
    }
}
