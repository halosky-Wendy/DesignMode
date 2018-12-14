package com.halosky.decorator;

import com.halosky.decorator.decorators.OneDecorator;
import com.halosky.decorator.instances.OneInstance;
import com.halosky.decorator.interfaceImpl.ExpandMainImpl;
import com.halosky.decorator.interfaces.MainInterface;

/**
 * 装饰器
 * @Author YangHuan
 * @Date 2018/12/14 15:03
 **/
public class Decorator {

    public static void main(String[] args){
        MainInterface mainInterface = new OneInstance();
        //一个装饰的过程
        MainInterface mainInter = new ExpandMainImpl(new OneDecorator(mainInterface));
        mainInter.show();
    }

}
