package com.halosky.Observer.interfaceImpl;

import com.halosky.Observer.interfaces.ObServer;

/**
 * @Author YangHuan
 * @Date 2018/12/15 15:34
 **/
public class User implements ObServer {
    private String name;
    private String msg;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.msg = msg;
        read();

    }

    public void read(){
        System.out.println(name+" 收到推送消息："+msg);
    }
}
