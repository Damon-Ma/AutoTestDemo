package com.damon.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu11111");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu22222");
    }
}
