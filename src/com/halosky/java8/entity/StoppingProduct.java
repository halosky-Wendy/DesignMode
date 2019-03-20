package com.halosky.java8.entity;

import com.halosky.java8.interfaces.IFunction;

/**
 * @Author YangHuan
 * @Date 2019/3/20 11:39
 **/
public class StoppingProduct {

    public void test(IFunction iFunction){
        String name = iFunction.convert();
        System.out.println(name);
    }

}
