package com.tw.bibilioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatalogTest {

    @Test
    public void shouldContainEmptyStringIfListIsEmpty() {
        List<Book> bookList = new ArrayList<Book>();
        Catalog catalog = new Catalog(bookList);

        assertEquals(catalog.toString(),"");
    }
}