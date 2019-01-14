package com.halosky.Proxy.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author YangHuan
 * @Date 2018/12/26 20:05
 **/
public class DynamicProxy implements InvocationHandler {

    // 被代理的实例
    Object object;

    public DynamicProxy(Object obj){
        this.object = obj;
    }

    /**
     * 覆盖InvocationHandler接口中的invoke()方法
     * 更重要的是，动态代理模式可以使得我们在不改变原来已有的代码结构
     * 的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到
     * 控制被代理对象的行为，下面的before、after就是我们可以进行特殊
     * 代码切入的扩展点了。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.object,args);

        return result;
    }
}
