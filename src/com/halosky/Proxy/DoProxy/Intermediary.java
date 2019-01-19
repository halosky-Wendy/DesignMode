package com.halosky.Proxy.DoProxy;

import com.halosky.Proxy.ManualProxy.halosky.HaloInvocationHandler;
import com.halosky.Proxy.ManualProxy.staticProxy.Person;

import java.lang.reflect.Method;

/**
 * @Author YangHuan
 * @Date 2019/1/18 19:38
 **/
public class Intermediary implements HaloInvocationHandler {

    // 被代理的实例
    Person object;

    public Intermediary(Person obj){
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入invoke方法");
        Object result = method.invoke(this.object,args);
        return result;
    }
}
