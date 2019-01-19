package com.halosky.Proxy.interfaceImpl;

import com.halosky.Proxy.interfaces.IPerson;

/**
 * @Author YangHuan
 * @Date 2019/1/18 19:36
 **/
public class YangXin implements IPerson {

    @Override
    public void findLove() {
        System.out.println("Hello!");
        System.out.println("my name is YangXin");
        System.out.println("I Love YangHuan!");
    }
}
