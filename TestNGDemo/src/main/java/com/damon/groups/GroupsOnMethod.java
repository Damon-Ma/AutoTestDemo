package com.damon.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("服务的测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务的测试方法2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端的测试方法3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端的测试方法4");
    }
    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("beforeGroupOnServer");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("afterGroupsOnServer");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("beforeGroupOnClient");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("afterGroupsOnClient");
    }
}
