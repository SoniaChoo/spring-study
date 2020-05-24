package com.sonia.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
