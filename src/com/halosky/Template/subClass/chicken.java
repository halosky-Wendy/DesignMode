package com.halosky.Template.subClass;

import com.halosky.Template.abstracts.EatTemplate;

/**
 * @Author YangHuan
 * @Date 2019/1/23 17:30
 **/
public class chicken extends EatTemplate {


    public void eat(){
        before();

        info();

        bite();
    }

    @Override
    public void info() {
        System.out.println("吃鸡肉");
    }
}
