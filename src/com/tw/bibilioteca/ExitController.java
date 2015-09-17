package com.tw.bibilioteca;

public class ExitController implements IController{

    @Override
    public IController executeAction() {
        System.exit(0);
        return this;
    }
}
