package com.damon.demo;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 读取properties文件
 * */
public class readProperties {
    static ResourceBundle bundle;

    public static void main(String[] args){
        bundle = ResourceBundle.getBundle("properties",Locale.CHINA);
        String userId = bundle.getString("userId");
        String userPwd = bundle.getString("userPwd");

        System.out.println("userId:"+userId+"\n"+"userPwd:"+userPwd);
    }


}
