package com.tw.bibilioteca;

public class User {
    private String libraryNumber;
    private String contact;
    private String phone;

    public User(String libraryNumber, String contact, String phone) {
        this.libraryNumber = libraryNumber;
        this.contact = contact;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return libraryNumber + " " + contact + " " + phone;
    }
}
