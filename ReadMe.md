---
typora-copy-images-to: doc\resource
---

# 考试报名及考务管理系统（EREMS）

## 1.简介

  本系统主要实现考试报名及考务管理系统的主要功能。系统的开发采用Java与SpringBoot编程环境,以MySQL为数据库，并以IntelliJ IDEA编辑器作为开发平台, 利用SpringBoot微服务框架为基础使用Mybatis作为ORM框架构建系统的数据接口以及实现RESTful风格的路径访问系统资源,同时采用了ThymeLeaf为模板引擎融入自适应UI框架Bootstrap美化用户界面。

  系统采用流行的MVC架构，以角色分类设计开发，主要分为三个部分：考生考试报名系统、考务人员管理系统、考务管理中心系统，通过各个子系统的协作运行，为所有社会考试体系的不同用户提供了定制功能及服务。

## 2.目录结构

doc：文档目录，包含数据库脚本以及流程图

src：源代码目录

=== main：运行代码目录

​        === java：运行代码

​         === resources：资源目录

​                 === static：静态文件目录，js脚本等前端资源

​                 === templates：模板文件目录，前端页面目录

​                 === application.yml：全局配置文件

  === test：测试代码目录

## 3.配置

环境：Windows

IDE：IDEA

语言：Java，HTML，CSS，JavaScript，SQL

框架：SpringBoot+Mybatis

数据库：MySQL

## 4.源代码运行

### 1）配置java环境

https://www.runoob.com/java/java-environment-setup.html

### 2）安装Typora软件阅读MarkDown文件

安装教程：https://jingyan.baidu.com/article/8ebacdf07c71f849f65cd5e5.html

### 3）MySQL操作

a.安装MySQL（window上安装，MySQL密码设置为123456，默认用户为root）：https://www.runoob.com/mysql/mysql-install.html

b.使用MySQL的workbench工具新建数据库erems，并将doc下的erems.sql脚本导入数据库（图片顺序为操作顺序）：

首先展开菜单栏选择import

![1571109170017](.\doc\resource\1571109170017.png)

接下来选择erems.sql的脚本位置，并使用new新建数据库

![1571109305796](.\doc\resource\1571109305796.png)

最后点击start import开始导入

![1571109405606](.\doc\resource\1571109405606.png)

当显示“1 of 1 imprted”时代表成功导入。

### 4）安装IDEA导入项目

安装教程：https://jingyan.baidu.com/article/afd8f4debd60f434e286e91f.html

a.使用主界面的open按钮，打开代码文件的所在目录导入

b.打开如图所在文件，右键显示菜单，点击运行项目

![1571109636479](.\doc\resource\1571109636479.png)

c.使用浏览器访问：`localhost:8088/erems/`，点击主页面的登录按钮，默认的用户名密码均为：admin，登录后显示下方页面

![1571110424691](.\doc\resource\1571110424691.png)

## 5.jar方式运行

1）参见“源代码运行”步骤的前三点操作

2）打开cmd命令行（win+R，输入cmd打开），切换到jar目录下

`cd X:\XX\erems\doc\`(替换X为盘符和路径)

命令行使用`jar -jar erems1.0.jar`运行代码，使用`localhost:8088/erems/`访问