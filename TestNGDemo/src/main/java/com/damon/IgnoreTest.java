package com.damon;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("Ignore1");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("Ignore2");
    }

    @Test(enabled = true)
    public void ingore3(){
        System.out.println("Ignore3");
    }
}
