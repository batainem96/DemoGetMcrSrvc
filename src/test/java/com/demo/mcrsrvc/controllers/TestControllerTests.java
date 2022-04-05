package com.demo.mcrsrvc.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestControllerTests {

    @Test
    public void testTest() {

        TestController testController = new TestController();

        String result = testController.test();

        assertEquals("Hello there!", result);

    }

}
