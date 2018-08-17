package com.damon.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.println("GroupsOnClass2222中的stu1111");
    }
    public void stu2(){
        System.out.println("GroupsOnClass2222中的stu22222");
    }
}
