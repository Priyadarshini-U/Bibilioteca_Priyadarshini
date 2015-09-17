package com.tw.bibilioteca;

public class User {
    private String libraryNumber;
    private String contact;
    private String phone;
    private UserRole role;

    public User(String libraryNumber, String contact, String phone, UserRole role) {
        this.libraryNumber = libraryNumber;
        this.contact = contact;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public String toString() {
        return libraryNumber + " " + contact + " " + phone + " " + role;
    }
}
