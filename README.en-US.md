---
typora-copy-images-to: doc\resource
---

# Examination Registration and Exam Administration Management System (EREMS)

## 1. Introduction

This system主要实现考试报名及考务管理系统的主要功能. 

The system is developed using Java and SpringBoot programming environment, with MySQL as the database, and IntelliJ IDEA as the development platform. The system is built on the SpringBoot microservices framework, using MyBatis as the ORM framework to construct data interfaces and implement RESTful-style path access to system resources. It also uses ThymeLeaf as the template engine and integrates the responsive UI framework Bootstrap to beautify the user interface.

The system adopts the popular MVC architecture, with role-based design divided into three main parts: Candidate Examination Registration System, Exam Administration Personnel Management System, and Exam Administration Center System. Through the collaborative operation of various subsystems, it provides customized functions and services for different users in the social examination system.

## 2. Directory Structure

doc: Document directory, containing database scripts and flowcharts

src: Source code directory

=== main: Runtime code directory

​        === java: Runtime code

​         === resources: Resource directory

​                 === static: Static file directory, js scripts and other front-end resources

​                 === templates: Template file directory, front-end page directory

​                 === application.yml: Global configuration file

  === test: Test code directory

## 3. Configuration

Environment: Windows

IDE: IDEA

Languages: Java, HTML, CSS, JavaScript, SQL

Frameworks: SpringBoot+Mybatis

Database: MySQL

## 4. Running Source Code

### 1) Configure Java Environment

https://www.runoob.com/java/java-environment-setup.html

### 2) Install Typora Software to Read Markdown Files

Installation tutorial: https://jingyan.baidu.com/article/8ebacdf07c71f849f65cd5e5.html

### 3) MySQL Operations

a. Install MySQL (on Windows, set MySQL password to 123456, default user is root): https://www.runoob.com/mysql/mysql-install.html

b. Use MySQL's workbench tool to create a new database named erems, and import the erems.sql script from the doc directory into the database (images follow the order of operations):

First, expand the menu bar and select import

![1571109170017](.\doc\resource\1571109170017.png)

Next, select the location of the erems.sql script, and use new to create a new database

![1571109305796](.\doc\resource\1571109305796.png)

Finally, click start import to begin the import

![1571109405606](.\doc\resource\1571109405606.png)

When it displays "1 of 1 imported", it means the import was successful.

### 4) Install IDEA to Import Project

Installation tutorial: https://jingyan.baidu.com/article/afd8f4debd60f434e286e91f.html

a. Use the open button on the main interface to open the directory where the code file is located to import

b. Open the file as shown in the figure, right-click to display the menu, and click to run the project

![1571109636479](.\doc\resource\1571109636479.png)

c. Use a browser to access: `localhost:8088/erems/`, click the login button on the main page, the default username and password are both admin, after logging in, the following page will be displayed

![1571110424691](.\doc\resource\1571110424691.png)

## 5. Running with JAR File

1) Refer to the first three steps of "Running Source Code"

2) Open cmd command line (win+R, input cmd to open), switch to the jar directory

`cd X:\XX\erems\doc\`(Replace X with the drive letter and path)

Run code using `jar -jar erems1.0.jar` in the command line, access using `localhost:8088/erems/`
