package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public class Guest implements Role {
    @Override
    public List<String> getOperations() {
        return new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Movie");
            add("List Movies");
            add("Log in");
        }};
    }

    @Override
    public List<String> getDisplayOperations() {
        return new ArrayList<String>() {{
            add("List Books");
            add("quit");
            add("CheckOut Book");
            add("List Movies");
            add("CheckOut Movie");
            add("return Book");
            add("Log in");
        }};
    }
}
