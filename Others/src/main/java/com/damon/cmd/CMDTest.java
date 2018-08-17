package com.damon.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDTest {

    static String result;

    public void cmdTest(String cmdCommand) {
        //cmd命令
        String cmd = "cmd /c\"  " + cmdCommand;

        try {
            //获取执行结果p
            Process p = Runtime.getRuntime().exec(cmd);

            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));

            //读取返回结果，如果不为空就一直读取
            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        CMDTest cmdTest = new CMDTest();
        cmdTest.cmdTest("ping www.baidu.com");
    }
}


