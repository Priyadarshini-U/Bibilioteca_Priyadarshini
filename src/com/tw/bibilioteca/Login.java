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
            if (userCredentials.get(libraryNumber).equals(password))
                return encrypt(libraryNumber);
        return new GuestUser().authenticate();
    }

    private String encrypt(String libraryNumber) {
        String result = "";
        for (int i = 0; i < libraryNumber.length(); i++) {
            int ascii = (int) libraryNumber.charAt(i);
            ascii += (3 % 26);
            result += (char) ascii;
        }
        return result;
    }
}
