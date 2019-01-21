package com.halosky.Proxy.ManualProxy.staticProxy;

import com.halosky.Proxy.ManualProxy.halosky.HaloInvocationHandler;

import java.lang.reflect.Method;

public class Matchmaker implements HaloInvocationHandler {

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
