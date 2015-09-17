package com.tw.bibilioteca;

public class User {
    private String libraryNumber;
    private String contact;
    private String phone;
    private UserRole role;

    public User(String libraryNumber, UserRole role, String contact, String phone) {
        this.libraryNumber = libraryNumber;
        this.contact = contact;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public String toString() {
        return libraryNumber + " " + contact + " " + phone;
    }

    public UserRole getRole() {
        return role;
    }
}
