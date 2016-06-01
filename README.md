# tour_website

# 简介
基于B/S架构的在线旅游产品展示平台


# 快速开始
- 下载链接：[点击下载](https://www.baidu.com)
- 克隆远程库命令：`git clone https://github.com/jikyoku/tour_website.git .`

---
# 运行环境
- web服务器：Tomcat 7.*
- 数据库   ： mysql 5.*


# 目录说明

```
tour_website/
├── bupt_cua_test-----------------------------------工程源码，导入到myeclipse下面可以直接运行
│   
├── db/---------------------------------------------数据库文件                             
│   └── cua_test.sql
└── bupa_cua_test.war-------------------------------编译后的war包，扔到tomcat的webapp目录下面可以直接运行，记得修改配置文件的数据库密码
```
<br>

# 运行方法
- 首先在mysql数据库中建立名为"cua_test"数据库，字符集设为utf-8,然后运行db目录线面的cua_test.sql文件，表结构建立完成；
- 启动myeclipse,导入bupt_cua_test工程，修改src目录下名为hibernate.cfg.xml文件中关于数据库用户名和密码的配置，改为自己数据库的用户名和密码；
  如下：<br>
  ``` 
    		<property name="hibernate.connection.username">your database name</property>
  ```
  <br>
  ```
		    <property name="hibernate.connection.password">your database passwd</property>
  ```
- 运行
  
  
