##常用依赖

1.网站下载地址:https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.6.RELEASE
 
 ```xml
<!--https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-webmvc</artifactId>
   <version>5.2.6.RELEASE</version>
</dependency>
```

2.**注解说明**
@Autowired:bytype -> byname

如果autowired不能唯一找到一个bean,则需要通过@Qualifier(value="xxx")来设置.

Resource:byname->bytype

@Component 放在类上,说明这个类被spring管理了.(注意:@Autowired和@Resource是放在属性或者set方法上的)

@Value可以放在属性上,也可以放在set方法上面



##使用注解开发
在spring4之后,要使用注解开发,必须要保证aop的包导入了(是指meavn里面).
使用注解还需要context约束和注解支持.

@Component有几个衍生的注解,我们在web开发中,会按照mvc三层架构分层,

功能都是一样的,都是把类扫描成组件,将某个类注册到spring容器中装配


@Dao[@Repository]
@Service[@Service]
@Controller[@Controller]


自动装配置:
@Autowired:bytype -> byname

如果autowired不能唯一找到一个bean,则需要通过@Qualifier(value="xxx")来设置.

@Resource:byname->bytype

@Component 放在类上,说明这个类被spring管理了.

@Value可以放在属性上,也可以放在set方法上面


**小结**:xml更加万能,适用于任何场合,维护相对简单,注解不是自己类使用不了,维护相对复杂.
xml与注解最佳实践:xml用来管理bean,注解只负责完成属性注入.我们在使用的过程中只需要注意一个问题,要在注解生效,必须有context支持,和context扫描
```xml
<!--指定要扫描的包,这个包下的注解就会生效-->
    <context:component-scan base-package="com.sonia"></context:component-scan>
    <context:annotation-config/>
```

使用注解开发的易错点:
读取xml文件是千万记得还是用
```java
 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
```
而不是
```java
ApplicationContext context = new AnnotationConfigApplicationContext("beans.xml");
```



 

