package com.sonia.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色:现在没有,需要等下自动生成
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们需要调用的接口对象
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent)proxyInvocationHandler.getProxy();//这里的proxy就是动态生成的,我们并没有去写
        proxy.rent();
    }
}
