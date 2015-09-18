package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class Admin implements Role{
    public List<String> getDisplayOperations() {
        return getOperations();
    }

    public List<String> getOperations() {
        return new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Book Status");
            add("Log out");
        }};
    }
}
