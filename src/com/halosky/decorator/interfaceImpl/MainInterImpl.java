package com.halosky.decorator.interfaceImpl;

import com.halosky.decorator.interfaces.MainInterface;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:11
 **/
public class MainInterImpl implements MainInterface {

    @Override
    public void show() {
        System.out.println("------------进入主接口实现类------------");
    }
}
