package com.damon;

import org.testng.annotations.*;

public class BasicAnnotation {

    //基本的注解
    @Test
    public void testCase1(){
        System.out.println("测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("测试用例2");
    }


    @BeforeMethod
    public void beforemethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("AfterMethod");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterclass(){
        System.out.println("AfterClass");
    }

    @BeforeSuite
    public void beforesuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("AfterSuite");
    }
}
