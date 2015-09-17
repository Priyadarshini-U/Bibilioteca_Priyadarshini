package com.tw.bibilioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CatalogOperationTest {

    @Test
    public void shouldCheckIfBookIsAvailableForExecuteCheckout() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeCheckout();

        verify(catalog).isEntityAvailableForCheckOut("name1");
    }

    @Test
    public void shouldCheckoutBookIfAvailable() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityAvailableForCheckOut(anyString())).thenReturn(true);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeCheckout();

        verify(catalog).checkoutEntity("name1");
    }

    @Test
    public void shouldNotCheckoutBookIfNotAvailable() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityAvailableForCheckOut(anyString())).thenReturn(false);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeCheckout();

        verify(catalog, times(0)).checkoutEntity("name1");
    }

    @Test
    public void shouldPrintSuccessMessageForSuccessfulCheckout() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityAvailableForCheckOut(anyString())).thenReturn(true);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeCheckout();

        verify(consoleDisplay).putOutput("Checkout succesful");
    }

    @Test
    public void shouldPrintFailureMessageForUnSuccessfulCheckout() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityAvailableForCheckOut(anyString())).thenReturn(false);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeCheckout();

        verify(consoleDisplay).putOutput("Checkout NOT succesful");
    }

    @Test
    public void shouldCheckIfBookIsReturnableForExecuteReturn() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeReturn();

        verify(catalog).isEntityReturnable("name1");
    }

    @Test
    public void shouldReturnBookIfReturnable() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityReturnable(anyString())).thenReturn(true);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeReturn();

        verify(catalog).returnEntity("name1");
    }

    @Test
    public void shouldNotRetunBookIfNotReturnable() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityReturnable(anyString())).thenReturn(false);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeReturn();

        verify(catalog, times(0)).checkoutEntity("name1");
    }

    @Test
    public void shouldPrintSuccessMessageForSuccessfulReturn() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityReturnable(anyString())).thenReturn(true);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeReturn();

        verify(consoleDisplay).putOutput("Return succesful");
    }

    @Test
    public void shouldPrintFailureMessageForUnSuccessfulReturn() {
        Catalog catalog = mock(Catalog.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(catalog.isEntityReturnable(anyString())).thenReturn(false);

        CatalogOperation catalogOperation = new CatalogOperation(consoleDisplay, catalog);
        catalogOperation.executeReturn();

        verify(consoleDisplay).putOutput("Return NOT succesful");
    }
}