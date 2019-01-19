package com.halosky.Proxy.ManualProxy.halosky;

import java.lang.reflect.Method;

public interface HaloInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
