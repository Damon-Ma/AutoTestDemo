package com.damon.demo;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduOCRDemo {
    // 设置APPID/AK/SK
    private static final String APP_ID = "11316412";
    private static final String API_KEY = "gEcSHRu1oUn0cHyD1FMkm8Yy";
    private static final String SECRET_KEY = "XMj1r2xIAmQZO5VRKSicPNxYwWGVUvSk";

    public static void main(String[] args) {
        BaiduOCRDemo bod = new BaiduOCRDemo();
        String msg = bod.getMsg();
        System.out.println(msg);
    }

    //
    public String getMsg() {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\Malik\\Desktop\\yuantu.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());


        //获取识别到的文字
        String result = res.get("words_result").toString();


        //写一个正则表达式
        Pattern p = Pattern.compile("\".*?\"");
        //用正则表达式匹配
        Matcher m = p.matcher(result);
        while (m.find()){
            String s = m.group();
            if (!s.equals("\"words\""))
                System.out.println(s);
        }

        System.out.println("\n------------------------\n"+result);
        return res.toString(2);

    }
}
