package com.damon.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDTest {

    static String result = "";

    public String cmdTest(String cmdCommand) {
        String cmd = "cmd /c\"  " + cmdCommand;

        try {
            //获取执行结果p
            Process p = Runtime.getRuntime().exec(cmd);

            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args){
        CMDTest cmdTest = new CMDTest();
        String s = cmdTest.cmdTest("ping www.baidu.com");
       // System.out.println(s);
    }
}


