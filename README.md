
# CampusCourseSelectionSystem 使用说明

## 项目概述

**校园选课系统**是一个简单的选课系统，使用 Thymeleaf、Spring Boot、Spring MVC、MyBatis 和 MySQL 技术构建。项目使用 Maven 作为构建工具，允许学生、教师和管理员进行不同的操作。

## 访问首页

在启动项目后，访问以下 URL 来查看系统首页：

```
http://localhost:端口/index
```

请将 `端口` 替换为实际的端口号。

## 功能模块

### 学生端

- **注册登录**：学生可以注册新账号并登录系统。
- **选课**：学生可以选择和添加课程到自己的选课列表。
- **查看成绩**：学生可以查看已选课程的成绩。

### 教师端

- **注册登录**：教师可以注册新账号并登录系统。
- **选择教学的课**：教师可以选择自己授课的课程。
- **退出教学的课**：教师可以退出正在授课的课程。
- **给学生打分**：教师可以为学生打分。

### 管理员端

- **注册登录**：管理员可以注册新账号并登录系统。
- **增删改查课程**：管理员可以进行课程的增、删、改、查操作。

## 环境要求

- **Java**：11
- **IDE**：IntelliJ IDEA 2023
- **数据库**：MySQL

## 软件下载

- **IntelliJ IDEA 2023**：[下载地址](https://www.jetbrains.com/idea/download/)
- **MySQL**：[下载地址](https://dev.mysql.com/downloads/mysql/)
- **Java JDK 11**：[下载地址](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

## 使用指南

1. **克隆项目**：
   ```bash
   git clone [项目的Git仓库URL]
   ```

2. **导入项目**：
   - 在 IntelliJ IDEA 中打开项目。

3. **配置数据库**：
   - 创建一个 MySQL 数据库，并配置 `application.properties` 文件中的数据库连接信息。

4. **构建项目**：
   - 使用 Maven 构建项目：
     ```bash
     mvn clean install
     ```

5. **运行项目**：
   - 在 IntelliJ IDEA 中运行 `CampusCourseSelectionSystem` 启动类，或者使用 Maven：
     ```bash
     mvn spring-boot:run
     ```

6. **访问系统**：
   - 打开浏览器，访问 `http://localhost:端口/index` 来使用系统。

## 效果图

效果图可以在 `pic` 目录下找到。