package com.halosky.prototype;

import com.halosky.prototype.entity.Person;

/**
 * @Author YangHuan
 * @Date 2018/12/21 15:07
 **/
public class Test {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.setUsername("halosky");
        p1.setPassword("123456");
        Person p2 = p1.getCopy();
        System.out.println(p2);

    }

}
