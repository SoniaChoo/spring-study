package com.sonia.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/*resource,autowired的区别, 都是自动装配的,都可以放到属性字段上
* resource通过byName,如果找不到名字,则通过bytype实现,如果两个都找不到的情况下,就报错!
* autowires通过byType, 并且要求这个对象必须存在,有时和qualifier注解一起使用*/
public class People {
    @Resource(name="cat222")

    private Cat cat;
    @Resource(name="dog222")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
