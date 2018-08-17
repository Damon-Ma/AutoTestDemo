package com.damon.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderOnMethod {
    /**
     * 根据方法传递参数
     * */
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("根据方法传递参数1：name:" + name + "\tage:" + age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("根据方法传递参数2：name:" + name + "\tage:" + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){

        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",23}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return result;
    }
}
