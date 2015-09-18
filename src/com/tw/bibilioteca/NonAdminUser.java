package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class NonAdminUser implements Role {
    public List<String> getOperations() {
        return new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Log out");
        }};
    }

    public List<String> getDisplayOperations() {
        return getOperations();
    }
}
