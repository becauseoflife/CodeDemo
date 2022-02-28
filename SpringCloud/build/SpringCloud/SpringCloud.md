# SpringCloud学习笔记



### SpringCloud



### 1、 微服务与微服务架构

​	一种软件开发技术- 面向服务的体系结构（SOA）架构样式的一种变体，它提倡将单一应用程序划分成一组小的服务，服务之间互相协调、互相配合，为用户提供最终价值。每个服务运行在其独立的进程中，服务与服务间采用轻量级的通信机制互相沟通（通常是基于HTTP的RESTful API）。每个服务都围绕着具体业务进行构建，并且能够独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据上下文，选择合适的语言、工具对其进行构建。

### 2、微服务优缺点

 [https://zhuanlan.zhihu.com/p/46459720](https://zhuanlan.zhihu.com/p/46459720)

### 3、 什么是SpringCloud？

String官网：https://spring.io/

SpringCloud中文网 ： [https://www.springcloud.cc/](https://www.springcloud.cc/)

**SpringCloud 架构亮点**

![春云图](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\1.svg)



Spring Cloud为开发人员提供了用于快速构建分布式系统中某些常见模式的工具（例如，配置管理，服务发现，断路器，智能路由，微代理，控制总线）。分布式系统的协调产生了样板模式，并且使用Spring云开发人员可以快速支持实现这些模式的服务和应用程序。它们可以在任何分布式环境中正常工作，包括开发人员自己的笔记本电脑，裸机数据中心和受管理的平台，例如Cloud Foundry。

### 4、SpringCloud 的特点

Spring Cloud专注于为典型的用例和扩展机制提供良好的开箱即用体验，以涵盖其他情况。

- 分布式/版本化配置
- 服务注册和发现
- 路由
- 服务到服务的呼叫
- 负载均衡
- 断路器
- 分布式消息传递

### 5、SpringCloud 和 SpringBoot 的关系

- SpringBoot专注于快速方便的开发单个个体微服务。-Jar
- SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供︰配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，分布式会话等等集成服务。
- SpringBoot可以离开SpringCloud独立使用，开发项目，但是SpringCloud离不开SpringBoot，属于依赖关系
- **SpringBoot专注于快速、方便的开发单个个体微服务，SpringCloud关注全局的服务治理框架** 

### 6、Dubbo 和 SpringCloud

##### 1、分布式 + 服务治理Dubbo

应用服务化拆分 + 消息中间件

![image-20220108011933743](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\image-20220108011933743.png)

- **CDN **的全称是Content Delivery Network，即[内容分发网络](https://baike.baidu.com/item/内容分发网络/4034265)。CDN是构建在现有网络基础之上的智能虚拟网络，依靠部署在各地的边缘服务器，通过中心平台的负载均衡、内容分发、调度等功能模块，使用户就近获取所需内容，降低网络拥塞，提高用户访问响应速度和命中率。CDN的关键技术主要有内容存储和分发技术。

- **LVS** 是Linux Virtual Server的简写，意即Linux虚拟服务器，是一个虚拟的服务器集群系统。本项目在1998年5月由章文嵩博士成立，是中国国内最早出现的自由软件项目之一。

- **Nginx** 是一个高性能的HTTP和[反向代理](https://baike.baidu.com/item/反向代理/7793488)web服务器，同时也提供了IMAP/POP3/SMTP服务。因它的稳定性、丰富的功能集、简单的配置文件和低系统资源的消耗而闻名。Nginx是一款轻量级的Web服务器/[反向代理](https://baike.baidu.com/item/反向代理/7793488)服务器及电子邮件（IMAP/POP3）代理服务器，其特点是占有内存少，并发能力强。

- **DFS** （分布式文件系统，Distributed File System）使用户更加容易访问和管理物理上跨网络分布的文件。DFS为文件系统提供了单个访问点和一个逻辑树结构，通过DFS，用户在访问文件时不需要知道它们的实际物理位置，即分布在多个服务器上的文件在用户面前就如同在网络的同一个位置。

- **Mycat** : Java语言编写的MySQL数据库网络协议的开源中间件。 [官网](http://mycat.org.cn/) 、 [GitHub地址](https://github.com/MyCATApache/Mycat-Server)。

- **Redis** 是一个开源（BSD许可），内存存储的数据结构服务器，可用作数据库，高速缓存和消息队列代理。它支持[字符串](https://www.redis.net.cn/tutorial/3508.html)、[哈希表](https://www.redis.net.cn/tutorial/3509.html)、[列表](https://www.redis.net.cn/tutorial/3510.html)、[集合](https://www.redis.net.cn/tutorial/3511.html)、[有序集合](https://www.redis.net.cn/tutorial/3512.html)，[位图](https://www.redis.net.cn/tutorial/3508.html)，[hyperloglogs](https://www.redis.net.cn/tutorial/3513.html)等数据类型。内置复制、[Lua脚本](https://www.redis.net.cn/tutorial/3516.html)、LRU收回、[事务](https://www.redis.net.cn/tutorial/3515.html)以及不同级别磁盘持久化功能，同时通过Redis Sentinel提供高可用，通过Redis Cluster提供自动[分区](https://www.redis.net.cn/tutorial/3524.html)。--中文网: [https://www.redis.net.cn/](https://www.redis.net.cn/)

- **MongoDB** 是专为可扩展性，高性能和高可用性而设计的数据库。它可以从单服务器部署扩展到大型、复杂的多数据中心架构。利用内存计算的优势，MongoDB能够提供高性能的数据读写操作。 MongoDB的本地复制和自动故障转移功能使您的应用程序具有企业级的可靠性和操作灵活性。--中文网：[https://docs.mongoing.com/](https://docs.mongoing.com/)

- **Elasticsearch** 是一个基于[Lucene](https://baike.baidu.com/item/Lucene/6753302)的搜索服务器。它提供了一个分布式多用户能力的[全文搜索引擎](https://baike.baidu.com/item/全文搜索引擎/7847410)，基于RESTful web接口。Elasticsearch是用Java语言开发的，并作为Apache许可条款下的开放源码发布，是一种流行的企业级搜索引擎。Elasticsearch用于[云计算](https://baike.baidu.com/item/云计算/9969353)中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。

- **MQ**（Message Queue）消息队列，是基础数据结构中“先进先出”的一种数据结构。指把要传输的数据（消息）放在队列中，用队列机制来实现消息传递——生产者产生消息并把消息放入队列，然后由消费者去处理。消费者可以到指定队列拉取消息，或者订阅相应的队列，由MQ服务端给其推送消息。一般用来解决应用解耦，异步消息，流量削峰等问题，实现高性能，高可用，可伸缩和最终一致性架构。

##### 2、对比

|              | Dubbo         | spring Cloud                 |
| ------------ | ------------- | ---------------------------- |
| 服务注册中心 | Zookeeper     | Spring Cloud Netfilx Eureka  |
| 服务调用方式 | RPC           | REST API                     |
| 服务监控     | Dubbo-monitor | Spring Boot Admin            |
| 断路器       | 不完善        | Spring Cloud Netflix Hystrix |
| 服务网关     | 无            | Spring Cloud Netflix Zuul    |
| 分布式配置   | 无            | Spring Cloud config          |
| 服务跟踪     | 无            | Spring Cloud Sleuth          |
| 消息总线     | 无            | Spring Cloud Bus             |
| 数据流       | 无            | Spring Cloud Stream          |
| 批量任务     | 无            | Spring Cloud Task            |

**最大的区别：SpringCloud 抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式。**

**解决的问题域不一样: Dubbo的定位是一款RPC框架，Spring Cloud的目标是微服务架构下的一站式解决方案。**











###  7、Rest 学习环境搭建

<Strong style="color:red">SpringCloud 版本和 SpringBoot版本的选择：</Strong>

![image-20220108142337602](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\image-20220108142337602.png)

![img](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\U%_T510OH0}U]6WKMUX7KD0.png)

#### 1、父项目搭建

**新建Maven项目作为父项目,Packageing是pom模式**

导入依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>SpringCloud</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- 打包方式 -->
    <packaging>pom</packaging>

    <properties>
        <spring-cloud-version>Hoxton.SR12</spring-cloud-version>
        <spring-boot-version>2.3.12.RELEASE</spring-boot-version>
        <mysql-connector-java-vesion>8.0.27</mysql-connector-java-vesion>
        <druid-version>1.2.8</druid-version>
        <mybatis-starter-version>2.2.0</mybatis-starter-version>
        <junit-version>4.12</junit-version>
        <log4j-core-sersion>2.17.1</log4j-core-sersion>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!-- SpringCloud 的依赖 : https://www.springcloud.cc/spring-cloud-greenwich.html#_quick_start-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud-version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!-- SpringBoot -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot-version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!-- 数据库 -->
            <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql-connector-java-vesion}</version>
            </dependency>
            <!-- 数据源 -->
            <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid-version}</version>
            </dependency>
            <!-- SpringBoot启动器 -->
            <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis-starter-version}</version>
            </dependency>
            <!-- junit -->
            <!-- https://mvnrepository.com/artifact/junit/junit -->
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit-version}</version>
                <scope>test</scope>
            </dependency>
            <!-- Log4j -->
            <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
            <dependency>
                <groupId>org.apache.logging.log4j</groupId>
                <artifactId>log4j-core</artifactId>
                <version>${log4j-core-sersion}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

#### 2、实体类模块搭建

**新建子模块 springcloud-api :**

依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringCloud</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>springcloud-api</artifactId>

    <!-- 当前Model自己需要的依赖，如果父依赖中配置了版本，这里不用写 -->
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>
</project>
```

IDEA 连接数据库:  `jdbc:mysql://localhost:3306?serverTimezone=Asia/Shanghai`

![image-20220108145514958](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\image-20220108145514958.png)

​	创建数据库:

![image-20220108145752276](D:\IDEA\B站_狂神说\SpringCloud\SpringCloud.assets\image-20220108145752276.png)



新建表：

```mysql
CREATE TABLE `dept`  (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_source` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO dept(dept_name, db_source) VALUES ("开发部", DATABASE());
INSERT INTO dept(dept_name, db_source) VALUES ("人事部", DATABASE());
INSERT INTO dept(dept_name, db_source) VALUES ("财务部", DATABASE());
INSERT INTO dept(dept_name, db_source) VALUES ("市场部", DATABASE());
INSERT INTO dept(dept_name, db_source) VALUES ("运维部", DATABASE());
```

数据库写完后写实体类：

```java
package com.example.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept 实体类
 * @author llp
 * @date 2022年01月08日 15:19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  // 链式写法
public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;
    // 看一下这个数据是存在哪个数据库中的字段
    // 微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库中
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
```

#### 3、服务提供者模块搭建

**新建子模块 springcloud-provider-dept-8001**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringCloud</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>springcloud-provider-dept-8001</artifactId>

    <dependencies>
        <!-- 我们需要拿到实体类，所以要配置 api model -->
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>springcloud-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- Junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <!-- test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- jetty -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <!-- 热部署工具 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
</project>
```

##### 配置文件

`application.yml` 配置文件：

```yml
server:
  port: 8001
# myBaits 配置
mybatis:
  type-aliases-package: com.example.springcloud.pojo
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
# spring 配置
spring:
  application:
    name: spring-provider-dept
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/workers?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password:
```

`mybatis-config.xml` 配置文件：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- mybatis 配置文件 -->
<configuration>
    <settings>
        <!-- 开启二级缓存 -->
        <setting name="cacheEnabled" value="true"/>
        <!-- 开启驼峰式命名 -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
</configuration>
```

##### Dao层

`DeptDao`

```java
package com.example.springcloud.dao;

import com.example.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:14
 */
@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept queryDept(Long id);

    List<Dept> queryAllDept();
}
```

deptMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace 定义一个对应的 Dao/Mapper 接口 -->
<mapper namespace="com.example.springcloud.dao.DeptDao">
    <insert id="addDept" parameterType="Dept">
        insert into db_01.dept(dept_name, db_source) VALUES (#{deptName}, DATABASE())
    </insert>

    <select id="queryDept" resultType="Dept" parameterType="Long">
        select * from db_01.dept where dept_no = #{id}
    </select>

    <select id="queryAllDept" resultType="Dept">
        select * from db_01.dept
    </select>
</mapper>
```

##### Service层

```java
package com.example.springcloud.service;

import com.example.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:29
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryDept(Long id);

    List<Dept> queryAllDept();
}
```

```java
package com.example.springcloud.service.impl;

import com.example.springcloud.dao.DeptDao;
import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author llp
 * @date 2022年02月28日 15:30
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryDept(Long id) {
        return deptDao.queryDept(id);
    }

    public List<Dept> queryAllDept() {
        return deptDao.queryAllDept();
    }
}
```

##### Controller层

```java
package com.example.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提供 restful 接口
 * @author llp
 * @date 2022年02月28日 15:41
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryDept(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }

}
```

##### 主启动器

```java
package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc 启动类
 * @auth llp
 * @date 2022年02月28日 15:49
 */
@SpringBootApplication
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class, args);
    }
}
```

启动访问测试接口。

#### 4、服务消费者模块搭建

引入依赖pom.xml;

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringCloud</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>springcloud-consumer-dept-80</artifactId>

    <!-- 实体类 + web -->
    <dependencies>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>springcloud-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 热部署工具 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
</project>
```

##### 配置文件

```yml
server:
  port: 80
```

##### controller层

```java
package com.example.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @desc
 * @auth llp
 * @date 2022年02月28日 17:39
 */
@RestController
public class DeptConsumerController {
    // 消费者，不应该有service层
    // RestTemplate , 有对应的请求方法，供我们直接调用，要注册到 Spring 中

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
```

##### 配置 RestTemplate

```java
package com.example.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @desc
 * @auth llp
 * @date 2022年02月28日 17:44
 */
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
```

启动项目并测试接口。









