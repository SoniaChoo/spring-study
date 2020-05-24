package com.sonia.demo04;

import com.sonia.demo02.UserService;
import com.sonia.demo02.UserServiceImpl;
import com.sonia.demo03.Host;
import com.sonia.demo03.Rent;

public class Client {
    public static void main(String[] args) {
        //真实角色,我们每次只要把真实角色改以下就可以变成代理另外一个类
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userService);//设置要代理的对象
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();//动态生成代理类
        //这里我原本写错了,我写成了UserService的实现类,UserServiceImpl,一直报错.
        proxy.select();
    }

//    public static void main(String[] args) {
//        //真实对象
//        UserServiceImpl userService = new UserServiceImpl();
//        //代理对象的调用处理程序
//        ProxyInvocationHandler pih = new ProxyInvocationHandler();
//        pih.setTarget(userService); //设置要代理的对象
//        UserService proxy = (UserService)pih.getProxy(); //动态生成代理类！
//        proxy.delete();
//    }
}
