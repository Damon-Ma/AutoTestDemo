package com.damon.controller;


import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@RestController
@Api(value = "/post",description = "post请求接口demo")
@RequestMapping(value = "/post")
public class PostMethodDemo {

    /**
     * post请求接口
     * */
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ApiOperation(value = "无参数post请求",httpMethod = "POST")
    public String post(){
        return "这是一个无参数的post请求";
    }

    /**
     * key:value 参数类型post请求接口
     * */
    @RequestMapping(value = "/postwithparam",method = RequestMethod.POST)
    @ApiOperation(value = "key：value格式的post请求",httpMethod = "POST")
    public String postwithparam(@RequestParam(value = "param",required = true) String param ){
        //传入参数param=true返回成功
        if (param.equals("true")){
            return "访问成功"+param;
        }
        return "访问失败参数是："+param;
    }

    /**
     * json格式参数的post请求
     * */
    @RequestMapping(value = "/postwithjson",method = RequestMethod.POST)
    @ApiOperation(value = "json格式参数的post请求",httpMethod = "POST")
    public String postwithjson(@RequestBody JSONObject json){
        return json.toString();
    }

    /**
     * 返回结果带cookies的post请求
     * 请求参数 json格式
     * userId：xxx，
     * userPwd：XXX
     * */
    @RequestMapping(value = "/postgetcookies",method = RequestMethod.POST)
    @ApiOperation(value = "返回结果带cookie的post请求",httpMethod = "POST")
    public String postgetcookies(@RequestBody JSONObject json,
                                HttpServletResponse response){
        String userId = json.getString("userId");
        String userPwd = json.getString("userPwd");
        if (userId.equals("123456") && userPwd.equals("abc123")){
            //创建一个cookie
            Cookie cookie = new Cookie("login","true");
            //将cookie加入响应结果中
            response.addCookie(cookie);
            return "获取cookie成功:"+cookie.getValue()+":"+cookie.getName();
        }
        log.info(json.toString());
        return "获取cookies失败";
    }

    /**
     * 必须携带cookies信息才能访问的post请求
     * cookies：  login=true
     * */
    @RequestMapping(value = "/postwithcookie",method = RequestMethod.POST)
    @ApiOperation(value = "必须携带cookies信息才能访问的post接口",httpMethod = "POST")
    public String postwithcookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "cookies验证成功！";
            }
        }
        return "cookies验证失败：" + cookies.toString();

    }
}
