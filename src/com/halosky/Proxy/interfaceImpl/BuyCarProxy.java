package com.halosky.Proxy.interfaceImpl;

import com.halosky.Proxy.interfaces.IBuyCar;
import com.halosky.Proxy.interfaces.ITest;

import javax.xml.ws.handler.Handler;

/**
 * @Author YangHuan
 * @Date 2018/12/26 19:28
 **/
public class BuyCarProxy implements IBuyCar {

    // 消费者
    private Customer customer;

    // 接收消费者
    public BuyCarProxy(Customer customer){
        this.customer = customer;
    }


    @Override
    public void buyCar() {
        this.customer.buyCar();
    }
}
