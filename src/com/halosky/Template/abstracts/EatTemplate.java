package com.halosky.Template.abstracts;

/**
 * @Author YangHuan
 * @Date 2019/1/23 17:28
 **/
public abstract class EatTemplate {


    public void before(){
        System.out.println("张嘴");
    }

    public abstract void info();

    public void bite(){
        System.out.println("咀嚼");
    }

}
