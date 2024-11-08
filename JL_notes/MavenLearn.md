<div style="text-align: center;">
    <font size="10">Maven-Learning<br><font size="5" color="#008b8b">by shydoors</font></font>
</div>

返回基础的学习:[java](JL.md)

# Why learn?

- Maven是一个java项目的**构建**和**管理**工具，定义项目的结构，依赖和项目，并使用统一化的方式进行***自动化构建***
<br>maven的官网：[ApacheMaven](https://maven.apache.org/)
## 优势：
1. 对于.jar管理更有优势（直接用仓库进行管理，没有会从仓库里自动下载）
2. .jar间存在依赖关系的话，会自动下载有依赖关系的包（例如：jar1依赖jar2，引入了jar1,jar2也会自动引入的）

# 安装使用
1. 下载并解压后，打开后如下
![img.png](Maven0.png)
2. 改配置
 - 找到conf文件里的seething，xml文件。
 - 本地的.jar库：<br>找到localRespository标签，标签内容就是本地的.jar仓库路径<br>所有的.jar都放这里，有需要的改一下![img.png](Maven1.png)
 - 修改.jar源：<br>
默认的.jar拉去网站是国外的，建议多配几个镜像
一个源找不到会从上往下找下一个源里的，jar

![img_1.png](Maven2.png)
项目中，示例.xml代码讲解
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>PTA.template</groupId>
    <artifactId>JavaIO</artifactId>
    <!--
    这个是你的项目名字
    -->

    <version>1.0-SNAPSHOT</version><!--
    1.0 snapshot 快照，一般是程序员自己调试用的
    版本有一般是3个数字组组成，以python 3.12.1举例
     3  表示主版本
     12 表示次版本
     6  表示修订版本
    版本之间改动的越大，版本改东的数字就越靠前。
    比如python 2到python 3 废除了许多用语法，改动较大
    比如python 2.3开始用的排序算法tim_sort()，它的上一个版本是2.2
    -->
    <dependencies>

    </dependencies>
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <!--

        语言分为两种，编译型语言和解释型语言

        具体区别就是，
        编译型先生成可执行文件，然后才能执行.比如C,C++,Java
        解释型语言边解释边执行，比如python,javascript,typescript

        maven.compiler.source指的就是编译用的JDK版本
        maven.compiler.target值的是执行文件用JDK版本


        java的可执行文件是.class文件
        C对应的是.exe
        C++对应的是.exe
        (其实python也可以生成.exe,看你用的是什么库了)
        -->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <!--
        project.build.sourceEncoding 这个规定编译时用的字节包
        -->
    </properties>

</project>
```