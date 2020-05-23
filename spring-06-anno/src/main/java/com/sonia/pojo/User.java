package com.sonia.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Component这个注解就相当于 <bean id="user" class="com.sonia.pojo.User"/>
@Component //组件
public class User {
    //相当于<property name = "name" value="zhuzhu"/>
    @Value("zhuzhu")
    public String name;

}
