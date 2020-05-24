package com.sonia.config;

import com.sonia.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
