package com.tw.bibilioteca;

import java.util.HashMap;

public class Users {
    HashMap<String, User> userInformation;

    public Users() {
        userInformation = new HashMap<String, User>();
        userInformation.put("34404444",new User("011-1111",UserRole.ADMIN,"lotus suites","808-323-3333"));
        userInformation.put("35505555",new User("022-2222",UserRole.USER,"lotus suites","808-323-3333"));
        userInformation.put("36606666",new User("033-3333",UserRole.ADMIN,"lotus suites","808-323-3333"));
        userInformation.put(new GuestUser().authenticate(),new User(new GuestUser().authenticate(),UserRole.GUEST,"",""));
    }

    public User getUserInformationFromToken(String token){
        return null;
    }
}
