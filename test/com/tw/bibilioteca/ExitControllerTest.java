package com.tw.bibilioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ExitControllerTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitOnExecution() {
        exit.expectSystemExit();
        new ExitController().executeAction();
    }
}