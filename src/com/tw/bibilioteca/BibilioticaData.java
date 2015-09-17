package com.tw.bibilioteca;

public class BibilioticaData {
    private Catalog books;
    private Catalog movies;
    private String sessionToken;

    public BibilioticaData(Catalog books, Catalog movies, String sessionToken) {
        this.books = books;
        this.movies = movies;
        this.sessionToken = sessionToken;
    }

    public Catalog getBookLibrary() {
        return books;
    }

    public Catalog getMoviesLibrary() {
        return movies;
    }

    public String getSessionToken() { return sessionToken; }
}
