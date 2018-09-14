package com.damon.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SecondTest implements JavaSamplerClient {
    private static final String URLNAME = "URL";
    private static final String DEFAULTURL = "http://www.baidu.com";

    /**
     *参数
     * @return arguments
     */
    public Arguments getDefaultParameters() {
        System.out.println("this is getDefaultParameters");
        Arguments arguments = new Arguments();
        arguments.addArgument(URLNAME,DEFAULTURL);
        return arguments;
    }


    private String inputUrl;
    /**
     *  获取输入的数据
     * @param javaSamplerContext
     */
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        inputUrl = javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("inputURL is:"+inputUrl);
        //System.out.println("this is setupTest");
    }

    /**
     * 在查看结果树中显示
     * @param javaSamplerContext
     * @return
     */
    private String resultData;

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("this is runTest");


        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(inputUrl);
            URLConnection connection = url.openConnection();

            byte[] buffer = new byte[1024];
            InputStream in = connection.getInputStream();

            while (in.read(buffer)!=-1){
                resultData = new String(buffer,"UTF-8");
                sb.append(resultData);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //resultData = "This is resultData";
        resultData = sb.toString();

        SampleResult result = new SampleResult();
        result.setResponseData(resultData,"UTF-8");
        result.setDataType(SampleResult.TEXT);
        result.setSuccessful(true); //告诉查看结果树访问结果是否成功
        result.setSampleLabel("自定义JAVA请求"); //改变查看结果树中显示的名称
        return result;
    }

    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("this is teardownTest");
    }


}
