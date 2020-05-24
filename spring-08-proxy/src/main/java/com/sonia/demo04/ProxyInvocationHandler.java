package com.sonia.demo04;

import com.sonia.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

//    private Object target;
//
//    public void setTarget(Object target) {
//        this.target = target;
//    }
//
//    public Object getProxy(){
//       return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
//    }
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //log(method.getName());
//        Object result = method.invoke(target, args);
//        return result;
//    }
//
//    public void log(String msg){
//        System.out.println("执行了"+msg+"方法");
//    }

        private Object target;

        public void setTarget(Object target) {
            this.target = target;
        }

        //生成代理类
        public Object getProxy(){
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),this);
        }

        // proxy : 代理类
        // method : 代理类的调用处理程序的方法对象.
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log(method.getName());
             method.invoke(target, args);
            return null;
        }

        public void log(String methodName){
            System.out.println("执行了"+methodName+"方法");
        }

}
