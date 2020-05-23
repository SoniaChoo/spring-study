package com.sonia.pojo;

public class UserT {
    private String name;

    public UserT(){
        System.out.println("uset的无参构造");
    }
    public UserT(String name) {
        this.name = name;
        System.out.println("usert的有参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
