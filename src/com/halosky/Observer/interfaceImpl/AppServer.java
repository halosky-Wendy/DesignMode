package com.halosky.Observer.interfaceImpl;

import com.halosky.Observer.interfaces.ObServer;
import com.halosky.Observer.interfaces.Observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YangHuan
 * @Date 2018/12/15 15:30
 **/
public class AppServer implements Observerable {
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<ObServer> list;

    private String msg;

    public AppServer(){
        list = new ArrayList<>();
    }

    @Override
    public void register(ObServer o) {
        list.add(o);
    }

    @Override
    public void remote(ObServer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObServer() {
            for(ObServer obServer : this.list){
                obServer.update(this.msg);
            }
    }

    public void setInfomation(String s){
        this.msg = s;
        System.out.println("通知消息:"+s);
        notifyObServer();
    }

}
