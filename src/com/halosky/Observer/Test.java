package com.halosky.Observer;

import com.halosky.Observer.interfaceImpl.AppServer;
import com.halosky.Observer.interfaceImpl.User;
import com.halosky.Observer.interfaces.ObServer;

/**
 * @Author YangHuan
 * @Date 2018/12/15 15:24
 **/
public class Test {

    public static void main(String[] args){
        AppServer appServer = new AppServer();

        ObServer user = new User("halosky");
        ObServer wendy = new User("wendy");

        appServer.register(user);
        appServer.register(wendy);

        appServer.setInfomation("hello java");

        System.out.println("----------------------------");

        appServer.remote(user);
        appServer.setInfomation("hello python");

    }

}
