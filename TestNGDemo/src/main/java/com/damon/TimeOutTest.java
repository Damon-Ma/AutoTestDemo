package com.damon;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 300)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(200);
    }

    @Test(timeOut = 300)
    public void testFailed() throws InterruptedException {
        Thread.sleep(400);
    }
}
