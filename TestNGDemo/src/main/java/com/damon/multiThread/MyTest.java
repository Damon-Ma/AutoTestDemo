package com.damon.multiThread;

import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void test1(){
        System.out.printf("MyTest当前线程：%s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("MyTest当前线程：%s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("MyTest当前线程：%s%n",Thread.currentThread().getId());
    }
}
