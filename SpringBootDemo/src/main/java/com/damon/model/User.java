package com.damon.model;

import lombok.Data;

/**
 * 用@Data注解省略get/set方法
 * */

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String sex;
    private int age;
    private String permission;
    private String isDelete;

    @Override
    public String toString(){
        return(
                "\n{id:"+id+",\n"+
                        "userName:"+userName+",\n"+
                        "age:"+age+",\n"+
                        "sex:"+sex+",\n"+
                        "permission:"+permission+",\n"+
                        "isDelete:"+isDelete+"}\n"
        );
    }
}
