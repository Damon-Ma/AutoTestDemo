package com.damon;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 我们期望结果为某个异常时
     * 比如：我们传入了某些不合法的参数，程序抛出了异常
     * 也就是说，我们预期结果就是这个异常
     * */

//这是一个失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是失败的异常测试");
    }
    //    这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是成功的异常测试");
        throw new RuntimeException();
    }
}
