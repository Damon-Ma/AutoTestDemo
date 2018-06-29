# AutoTestDemo

本项目主要用于整理和记录学习自动化测试中一些工具类的demo，以备后用。

第一部分：appium移动端UI自动化

第二部分：selenium Web端UI自动化

第三部分：接口自动化

    接口自动化，使用HttpClient发送GET或POST请求，本demo中包含
    
    1.GET请求
    2.携带参数和Cookies的GET请求
    3.携带参数和Cookies的POST请求

第四部分：springboot简单demo
   
    demo实现get请求接口，post请求接口，需要cookie/参数请求的接口
    
    springboot使用到的依赖包：
        1.parent标签下的spring-boot-starter-parent包
        2.spring-boot-starter-web
        3.springfox-swagger2：用来生成接口文档
        4.springfox-swagger-ui
        5.lombok：工具包自动生成get/set等方法，打印日志
        6.fastjson：操作json格式的数据
        7.mysql-connector-java：连接mysql的依赖包
        8.mybatis-spring-boot-starter：持久层框架，用来操作数据库
        9.如果编译的时候提示找不到log4j包，则需要添加log4j的排斥包（demo中已添加）
    资源文件配置：
        1.application.yml 
          （一）配置端口号
          （二）配置日志文件目录
          （三）配置数据库连接
          （四）配置mybatis读取目录
        2.logback.xml
            固定写法
        3.mybatis-config.xml
            mybatis配置文件
        4.mapper/mysql.xml
            编写SQL语句
    包名、类名：
        1.Application.java
            main方法，基本固定写法
        2.model包
            编写需要使用lombok工具的类
        3.config包
            编写配置类，如：swagger的配置
        4.controller包
            编写接口类。

第五部分：工具类demo
    