package com.halosky.Proxy.ManualProxy.staticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author YangHuan
 * @Date 2019/1/19 16:54
 **/
public class Matchmaker implements InvocationHandler {

    private Person target;


    public Matchmaker(Person target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我来帮你找对象");
        return method.invoke(this.target,args);
    }
}
