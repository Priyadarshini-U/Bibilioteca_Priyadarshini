package com.tw.bibilioteca;

import java.util.HashMap;

public class Login {
    private HashMap<String, String> userCredentials;

    public Login() {
        this.userCredentials = new HashMap<String, String>();
    }

    private void loadExistingUserLoginCredentials() {
        userCredentials.put("011-1111", "1");
        userCredentials.put("022-2222", "2");
        userCredentials.put("033-3333", "3");
    }

    public String authenticate(String libraryNumber, String password) {
        loadExistingUserLoginCredentials();
        if (userCredentials.containsKey(libraryNumber))
                return libraryNumber;
        return null;
    }
}
