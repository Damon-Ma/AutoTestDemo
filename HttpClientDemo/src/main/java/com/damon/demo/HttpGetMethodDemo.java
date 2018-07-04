package com.damon.demo;

import com.damon.util.HttpGetParam;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class HttpGetMethodDemo {
    /**
     * 1.声明读取properties文件的Bundle
     * 2.声明一个存放服务器地址的url
     * 3.声明一个cookieStore对象
     * 4.声明一个String类型的用来存放响应结果的对象
     * */
    private static ResourceBundle bundle;
    private static String url;
    private CookieStore store;
    private String result;

    //初始化服务器地址
    public void getUrl(){
        //记载配置文件
        bundle=ResourceBundle.getBundle("url",Locale.CHINA);
        //根据key值读取value
        url = bundle.getString("test.url");
        System.out.println("测试服务器地址是："+url);
    }


    /**
     * get请求
     * */
    public void get() throws IOException {
        //拼接接口地址
        String testUrl;
        String uri = bundle.getString("get.uri");
        testUrl = url + uri ;
        System.out.println("测试接口地址是："+testUrl);

        //创建一个HttpGet对象,并传入接口地址
        HttpGet get = new HttpGet(testUrl);
        //定义一个HttpClient对象
        DefaultHttpClient client = new DefaultHttpClient();
        //使用HttpClient对象访问接口
        HttpResponse response = client.execute(get);
        //将请求结果转换成String类型
        result = EntityUtils.toString(response.getEntity());
        System.out.println("get请求结果："+result);

    }

    /**
     * 带参数访问的get请求
     * */
    public void getWithParam() throws IOException {

        //添加参数，这里用到参数的格式化，使用封装好的HttpGetParam类，代码来自CSDN：@Lambda_up
        //首先创建这个类的对象
        HttpGetParam httpGetParam = new HttpGetParam();
        //调用格式化的方法需要传入map格式的数据，首先创建一个map对象，并传入我们的参数
        //接口demo中只要传入start和end两个任意的Integer类型的参数即可
        Map param = new HashMap();
        param.put("start",1);
        param.put("end",10);
        //调用参数格式化方法
        String stringParam = httpGetParam.urlParamterStringer("?",param);

        //拼接地址
        String testURL= url + bundle.getString("getwithparam.uri")+stringParam;
        System.out.println("测试接口地址："+testURL);
        HttpGet get = new HttpGet(testURL);
        DefaultHttpClient client = new DefaultHttpClient();
        //开始请求
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("带参数get请求结果："+result);
    }
    /**
     * 访问带cookies信息的get请求
     * */
    public void getCookies() throws IOException {
        String testUrl = url+bundle.getString("getcookie.uri");
        System.out.println("测试接口地址："+testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("获取cookies的get请求结果："+result);
        //添加cookies到cookieStore中
        store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookies信息是： "+name+"="+value);
        }
    }

    /**
     * 需要带Cookies信息才能访问的get请求
     *
     * */
    public void getWithCookies() throws IOException {
        String testUrl = url +bundle.getString("getwithcookie.uri");
        System.out.println("测试接口地址："+testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //添加cookie信息
        client.setCookieStore(store);

        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());

        System.out.println("需要cookie才能访问的get请求："+result);
    }



    
    public static void main(String[] args) throws IOException {
        HttpGetMethodDemo getDemo = new HttpGetMethodDemo();
        getDemo.getUrl();
        getDemo.get();
        getDemo.getWithParam();
        getDemo.getCookies();
        getDemo.getWithCookies();
    }


}
