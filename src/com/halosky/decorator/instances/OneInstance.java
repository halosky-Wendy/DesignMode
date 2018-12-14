package com.halosky.decorator.instances;

import com.halosky.decorator.interfaces.MainInterface;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:21
 **/
public class OneInstance implements MainInterface {
    @Override
    public void show() {
        System.out.println("我是第一个被装饰的对象");
    }
}
