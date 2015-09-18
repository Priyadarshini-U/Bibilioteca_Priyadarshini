package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class User implements EntityDetails{
    private String libraryNumber;
    private String contact;
    private String phone;
    private Role role;

    public User(String libraryNumber, Role role, String contact, String phone) {
        this.libraryNumber = libraryNumber;
        this.contact = contact;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public String toString() {
        return libraryNumber + " " + contact + " " + phone;
    }

    public Role getRole() {
        return role;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    @Override
    public List<String> fields() {
        List<String> fields = new ArrayList<String>();
        fields.add("library Number");
        fields.add("contact");
        fields.add("phone");
        return fields;
    }
}
