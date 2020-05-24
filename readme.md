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

@Component 放在类上,说明这个类被spring管理了.(注意:@Autowired和@Resource是放在属性或者set方法上的.但是这个属性是另外一个类)

@Value可以放在属性上,也可以放在set方法上面



##使用注解开发
在spring4之后,要使用注解开发,必须要保证aop的包导入了(是指meavn里面).
使用注解还需要context约束和注解支持.

- @Component有几个衍生的注解,我们在web开发中,会按照mvc三层架构分层,

功能都是一样的,都是把类扫描成组件,将某个类注册到spring容器中装配


- @Dao[@Repository]

- @Service[@Service]

- @Controller[@Controller]


自动装配置:
- @Autowired:bytype -> byname

如果autowired不能唯一找到一个bean,则需要通过@Qualifier(value="xxx")来设置.

- @Resource:byname->bytype

- @Component 放在类上,说明这个类被spring管理了.

- @Value可以放在属性上,也可以放在set方法上面


- **小结**:

xml更加万能,适用于任何场合,维护相对简单,注解不是自己类使用不了,维护相对复杂.
xml与注解最佳实践:xml用来管理bean,注解只负责完成属性注入.我们在使用的过程中只需要注意一个问题,要在注解生效,必须有context支持,和context扫描
```xml
<!--指定要扫描的包,这个包下的注解就会生效-->
    <context:component-scan base-package="com.sonia"></context:component-scan>
    <context:annotation-config/>
```

使用注解开发的易错点:
- 注意点1

    读取xml文件是千万记得还是用
```java
 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
```
而不是
```java
ApplicationContext context = new AnnotationConfigApplicationContext("beans.xml");
```

- 注意点2
```java
//使用注解开发的话,context后面的getBean方法中的参数name需要是对象名的首字母小写,
        //例如,对象名是UserT,那么我们在getBean中的系数只可以写userT而不能写UserT
        UserT user = context.getBean("userT", UserT.class);
```


##使用java的方式配置Spring
- 我们现在要完全不使用Spring的xml配置了,全权交给Java来做!
JavaConfig是SPring的一个子项目,在Spring4之后,变成了一个核心功能.

- 以下是代码实现

实体类:

```java
//这里的component注解的意思和spring-06中的含义是一样的,就是说明这个类被spring接管了,注册到了容器中.
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("sonia")//这个就是属性注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

配置文件

```java
@Configuration//这个也会被spring容器托管,注册到容器中,因为他本来就是一个component,
// configuration代表这是一个配置类,就和我们之前的beans.xml是一样的
@ComponentScan("com.sonia.pojo")
@Import(SoniaConfig2.class)
public class SoniaConfig {
    //注册bean,就相当于我们之前写的一个bean标签,
    //这个方法的名字就相当于bean标签中的id属性,
    //这个方法的返回值就相当于是bean标签中的class属性.
    @Bean
    public User getUser() {
        return new User();//就是返回要注入到bean的对象.
    }
}
```

测试类

```java
public class Mytest {
    public static void main(String[] args){
        //如果完全使用了配置类方式去做,我们就只能通过AnnotationConfig上下文来获取容器,通过配置类的class对象加载.
        //但是如果不是完全用配置类,任然有xml文件,那么我们还是用ClassPath上下文来获取容器.
        ApplicationContext context = new AnnotationConfigApplicationContext(SoniaConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user);
    }
}
```

这种纯java的配置方式,在springboot中随处可见.

##10.代理模式

- 为什么要学代理模式,因为这是Spring aop的底层!
[SpringAop 和SpringMVC面试会比较经常遇到]

- 静态代理

- 动态代理

#### 10.1静态代理
1.角色分析:
- 抽象角色:一般会使用接口或者抽象类来解决
```java
//租房
public interface Rent {
    public void Rent();
}
```
- 真实角色:被代理的角色
```java
public class Host implements Rent{
    public void Rent() {
        System.out.println("房东的房子要出租");
    }
}
```
- 代理角色:代理真实角色,代理真实角色后我们一般会做一些附属操作
```java
public class RentProxy implements Rent{
    private Host host;

    public RentProxy(){}
    public RentProxy(Host host) {
        this.host = host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void Rent() {
        host.Rent();
        seeHouse();
        contract();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void contract(){
        System.out.println("中介带你签合同");
    }
}
```
- 客户:访问代理对象的人.
```java
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理,中介帮房东租房子,但是代理一般会有一些附属操作
        RentProxy rentProxy = new RentProxy(host);
        //你不用面对房东,直接找中介租房
        rentProxy.Rent();
    }
}
```
2.代理模式的好处:
- 可以是真实的角色更加纯粹
- 公共业务交给了代理,实现了业务的分工
- 公告业务扩展的时候,方便集中管理!

缺点:一个真实角色就会产生一个代理角色,代码量会翻倍,开发效率会变低.

####10.2 加深对静态代理的理解

代码对应08-demo02

####10.3动态代理
- 动态代理的静态代理的角色一样
- 动态代理类是动态生成的,不是我们直接写好的
- 动态代理按类来分可以分为两大类:
    - 基于接口的动态代理(JDK)(我们在这里使用)
    - 基于类的动态代理(cglib)
    - java字节码:javassist
    
- 需要了解两个类:

    - Proxy:代理   

    - InvocationHandler:调用处理程序

- 动态代理的好处 
    - 可以是真实的角色更加纯粹
    - 公共业务交给了代理,实现了业务的分工
    - 公告业务扩展的时候,方便集中管理! 
    - 一个动态代理类可以代理多个类,只要是实现了这个接口
    
##11.AOP
- 要用注解实现aop必须导入一个依赖包:织入

- 方式一:使用spring的接口[主要是API接口实现,功能最强大]

- 方法二:使用自定义类来实现Aop[主要是切面]

- 方式三:使用注解实现
    







 

