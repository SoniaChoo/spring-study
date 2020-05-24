package com.sonia.pojo;

public class RentProxy implements Rent{
    private Host host;

    public RentProxy(){}
    public RentProxy(Host host) {
        this.host = host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void Rent() {
        host.Rent();
        seeHouse();
        contract();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void contract(){
        System.out.println("中介带你签合同");
    }
}
