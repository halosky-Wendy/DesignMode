package com.halosky.springTest.entity;

import org.junit.Test;

/**
 * @Author YangHuan
 * @Date 2019/3/2 17:11
 **/
public class B extends A {

    private String name = "123";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void testA(){
        setA(this);
        A a = getA();
        System.out.println(a == null);
    }

}
