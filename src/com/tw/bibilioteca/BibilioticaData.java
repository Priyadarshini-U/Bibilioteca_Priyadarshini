package com.tw.bibilioteca;

public class BibilioticaData {
    private Catalog books;
    private Catalog movies;

    public BibilioticaData(Catalog books, Catalog movies) {
        this.books = books;
        this.movies = movies;
    }

    public Catalog getBookLibrary() {
        return books;
    }

    public Catalog getMoviesLibrary() {
        return movies;
    }
}
