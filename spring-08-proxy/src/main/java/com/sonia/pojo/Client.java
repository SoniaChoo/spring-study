package com.sonia.pojo;

public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理,中介帮房东租房子,但是代理一般会有一些附属操作
        RentProxy rentProxy = new RentProxy(host);
        //你不用面对房东,直接找中介租房
        rentProxy.Rent();
    }
}
