package com.tw.bibilioteca;

public class CatalogOperation {
    private ConsoleDisplay display;
    private Catalog catalogData;

    public CatalogOperation(ConsoleDisplay display, Catalog catalogData) {
        this.display = display;
        this.catalogData = catalogData;
    }

    public Catalog executeCheckout() {
        String name = display.getString();
        if (catalogData.isBookAvailableForCheckOut(name)) {
            catalogData.checkoutEntity(name);
            display.putOutput("Checkout succesful");
        } else
            display.putOutput("Checkout NOT succesful");
        return catalogData;
    }

    public Catalog executeReturn() {
        String name = display.getString();
        if (catalogData.isBookReturnable(name)) {
            catalogData.returnEntity(name);
            display.putOutput("return succesful");
        } else
            display.putOutput("return NOT succesful");
        return catalogData;
    }
}
