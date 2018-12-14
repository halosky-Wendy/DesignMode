package com.halosky.decorator.interfaceImpl;

import com.halosky.decorator.interfaces.MainInterface;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:13
 **/

public class ExpandMainImpl implements MainInterface {
    private MainInterface mainInterface;

    public ExpandMainImpl(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }


    @Override
    public void show() {
        System.out.println("----------进入主接口拓展实现----------");
        this.mainInterface.show();
        System.out.println("----------退出主接口拓展实现----------");
    }
}
