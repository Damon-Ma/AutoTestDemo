package com.damon.demo;

import com.damon.model.Test1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class mybatis {
    private SqlSession session;

    /**
     * 构造方法，初始化执行sql语句的sqlsession
     * */
    public mybatis(){
        try {
            //获取配置文件
            Reader reader = Resources.getResourceAsReader("DBConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            //能够执行配置文件中的sql语句
            //这里有个坑，factory.openSession();方法需要传入参数判断是否立即提交，true为立即提交，false为不提交
            //如果不写或者写false需要在后面加session.commit()来提交
            session = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * insert语句
     * */
    public void insertSQL(){

        //声明test1对象
        Test1 test1 = new Test1();
        test1.setUserId("123457");
        test1.setUserPwd("abc123");
        test1.setAge("19");
        test1.setSex("女");
        //执行插入数据的sql语句
        System.out.println(test1.toString());
        int result = session.insert("add",test1);
        System.out.println("insert语句执行结果"+result);
    }
    /**
     * select语句
     * */
    public void selectSQL(){
        Test1 test1 = new Test1();
        test1.setUserId("123456");
        Test1 result = session.selectOne("get",test1);
        System.out.println("查询结果是:"+result.toString());
    }
    /**
     * update语句
     * */
    public void updateSQL(){
        Test1 test1 = new Test1();
        test1.setUserId("123457");
        test1.setAge("20");
        test1.setUserPwd("abcabc");
        test1.setSex("woman");
        System.out.println(test1);
        int result = session.update("update",test1);
        System.out.println("update语句执行结果："+result);
    }
    /**
     * delete语句
     * */
    public void deleteSQL(){
        Test1 test1 = new Test1();
        test1.setUserId("123457");

        int result = session.delete("delete",test1);
        System.out.println("delete语句执行结果："+result);
    }
    public static void main(String[] args){
        mybatis mybatis = new mybatis();
       // mybatis.insertSQL();
        mybatis.selectSQL();
        mybatis.updateSQL();
        mybatis.deleteSQL();
    }



}
