package com.tw.bibilioteca;

import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void shouldHaveNameInItsStringOutput() {
        Book book = new Book("name", "author", new Date());

        assertTrue(book.toString().contains("name"));
    }
}