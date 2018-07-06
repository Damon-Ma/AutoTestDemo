# AutoTestDemo

本项目主要用于整理和记录学习自动化测试中一些工具类的demo，以备后用。

第一部分：appium移动端UI自动化

第二部分：selenium Web端UI自动化

第三部分：接口自动化HttpClient

    接口自动化demo，使用HttpClient发送GET或POST请求，本demo中包含:
        get请求、带参数的get请求、返回cookies的get请求、带cookies的get请求
        post请求、带参数（kv格式/json格式）的post请求、返回cookies的post请求、带cookies的post请求
    
    一、依赖包
        1.httpclient包
        2.json包
    二、配置文件
        1.properties配置文件，用来存放接口地址
    三、包名、类名
        util包中为格式化get请求参数的类
        
        

第四部分：springboot简单demo
   
    demo实现get请求接口，post请求接口，需要cookie/参数请求的接口
    
    一、springboot使用到的依赖包：
        1.parent标签下的spring-boot-starter-parent包
        2.spring-boot-starter-web
        3.springfox-swagger2：用来生成接口文档
        4.springfox-swagger-ui
        5.lombok：工具包自动生成get/set等方法，打印日志
        6.fastjson：操作json格式的数据
        7.如果编译的时候提示找不到log4j包，则需要添加log4j的排斥包（demo中已添加）
    二、资源文件配置：
        1.application.yml 
          （一）配置端口号
          （二）配置日志文件目录
        2.logback.xml
            固定写法
    三、包名、类名解释：
        1.Application.java
            main方法，基本固定写法
        2.model包
            编写需要使用lombok工具的类
        3.config包
            编写配置类，如：swagger的配置
        4.controller包
            编写接口类。

第五部分：TestNG


第六部分：工具类demo
    
    一、读取properties文件
        使用ResourceBundle类
    二、mybatis
        1.引入依赖包：
            mybatis
            mysql-connector-java
            lombok
        2.创建数据库配置文件
            DBConfig.xml
        3.创建编写SQL语句的xml文件
            SQLMapper.xml
        4.创建model包
            存放数据库中的键，使用lombok包中的Data注解，免写set/get方法    
        5.
    三、openCV
    
    四、百度OCR
    
第七部分：其他demo