package com.tw.bibilioteca;

public class CatalogOperation {
    private ConsoleDisplay display;
    private Catalog catalogData;

    public CatalogOperation(ConsoleDisplay display, Catalog catalogData) {
        this.display = display;
        this.catalogData = catalogData;
    }

    public Catalog executeCheckout(String user) {
        String name = display.getString();
        if (catalogData.isEntityAvailableForCheckOut(name)) {
            catalogData.checkoutEntity(name, user);
            display.putOutput("Checkout succesful");
        } else
            display.putOutput("Checkout NOT succesful");
        return catalogData;
    }

    public Catalog executeReturn() {
        String name = display.getString();
        if (catalogData.isEntityReturnable(name)) {
            catalogData.returnEntity(name);
            display.putOutput("Return succesful");
        } else
            display.putOutput("Return NOT succesful");
        return catalogData;
    }
}
