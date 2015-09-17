package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExitControllerTest {

    @Test
    public void shouldReturnExitControllerOnExecution() {
        IController controller = new ExitController().executeAction();

        assertEquals(controller.getClass(), ExitController.class);
    }
}