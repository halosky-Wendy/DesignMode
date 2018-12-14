package com.halosky.decorator.decorators;

import com.halosky.decorator.interfaces.MainInterface;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:18
 **/
public class TwoDecorator implements MainInterface {

    private MainInterface mainInterface;

    public TwoDecorator(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }

    @Override
    public void show() {
        this.mainInterface.show();
        System.out.println("=------------进入第二个装饰器---------------");
    }
}
