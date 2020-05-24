package com.sonia.demo02;

public class UserServiceImpl implements UserService{
    public void add(){
        System.out.println("增加了一个业务");
    }
    public void delete(){
        System.out.println("删除了一个业务");
    }
    public void update(){
        System.out.println("更新了一个业务");
    }
    public void select(){
        System.out.println("查询了一个业务");
    }
}
