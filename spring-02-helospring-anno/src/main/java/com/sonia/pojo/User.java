package com.sonia.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
//public class User {
//    //相当于<property name = "name" value="zhuzhu"/>
//    @Value("zhuzhu")
//    public String name;
//
//}
public class User {
//    @Value("chou yuguo")
    private String name = "zhuzhu";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
