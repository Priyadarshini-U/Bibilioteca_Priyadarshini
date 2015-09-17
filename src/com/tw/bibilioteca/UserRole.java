package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.List;

public enum UserRole {
    ADMIN,
    USER {
        @Override
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
    },
    GUEST {
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
    };

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

