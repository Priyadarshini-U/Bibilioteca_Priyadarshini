package com.tw.bibilioteca;

public class WelcomeMessage {
    public final String welcomeMessage = "welcome to Bibilioteca";

    public String message() {
        return welcomeMessage;
    }

    @Override
    public String toString() {
        return message();
    }
}
