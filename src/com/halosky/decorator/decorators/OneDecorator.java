package com.halosky.decorator.decorators;

import com.halosky.decorator.interfaces.MainInterface;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:15
 **/
public class OneDecorator implements MainInterface {

    private MainInterface mainInterface;

    public OneDecorator(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }

    @Override
    public void show() {
        System.out.println("----------第一个装饰器进入------");
        this.mainInterface.show();
        System.out.println("----------第一个装饰器结束----------");
    }
}
