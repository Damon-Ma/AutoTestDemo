package com.damon.demo;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.*;

public class HttpPostMethodDemo {
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

    //post请求
    public void post() throws IOException {
        String testUrl = url+bundle.getString("post.uri");
        System.out.println("测试接口地址："+testUrl);
        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("post请求结果是："+result);
    }
    /**
     * 带参数请求的post请求(kv格式)
     * */
    public void postWithParam() throws IOException {
        //定义一组参数
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("param","true"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);


        String testUrl = url+bundle.getString("postwithparam.uri");
        System.out.println("测试接口地址："+testUrl);

        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //添加请求参数
        post.setEntity(formEntity);

        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("请求结果："+result);
    }
    /**
     * 带参数的post请求（json格式）
     * */
    public void postwithjson() throws IOException {
        String testUrl = url+bundle.getString("postwithjson.uri");
        System.out.println("测试接口地址："+testUrl);
        //定义json格式参数
        JSONObject json = new JSONObject();
        json.put("name","value");
        //将json格式参数转换成StringEntity
        StringEntity entity = new StringEntity(json.toString(),"utf-8");

        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //添加头信息
        post.setHeader("content-type","application/json");
        //添加参数
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("请求结果："+result);
    }

    /**
     * 返回cookies的post请求
     * 需要传入json格式的参数
     * userId=123456
     * userPwd=abc123
     * */
    public void getcookies() throws IOException {
        String testUrl = url+bundle.getString("postgetcookies.uri");
        System.out.println("测试接口地址："+testUrl);
        //定义请求参数
        JSONObject json = new JSONObject();
        json.put("userId","123456");
        json.put("userPwd","abc123");
        StringEntity entity = new StringEntity(json.toString(),"utf-8");

        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置请求头
        post.setHeader("content-type","application/json");
        //添加参数
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("请求结果："+result);
        //获取cookies
        store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie :cookies){
            System.out.println("获取到的cookies是："+cookie.getName()+":"+cookie.getValue());
        }
    }
    /**
     * 需要携带cookies信息才能访问的post请求
     * */
    public void postwithcookies() throws IOException {
        String testUrl = url+bundle.getString("postwithcookie.uri");
        System.out.println("测试接口地址："+testUrl);
        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(store);

        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("请求结果："+result);
    }

    public static void main(String[] args) throws IOException {
        HttpPostMethodDemo post = new HttpPostMethodDemo();
        post.getUrl();
        post.post();
        post.postWithParam();
        post.postwithjson();
        post.getcookies();
        post.postwithcookies();
    }
}
