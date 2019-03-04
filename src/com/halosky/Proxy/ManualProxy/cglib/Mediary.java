package com.halosky.Proxy.ManualProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author YangHuan
 * @Date 2019/1/21 22:15
 **/
public class Mediary implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("进入回调方法");
        methodProxy.invokeSuper(o,objects);
        return o;
    }
}
