package com.halosky.Proxy;

import com.halosky.Proxy.dynamic.proxy.DynamicProxy;
import com.halosky.Proxy.interfaceImpl.BuyCarProxy;
import com.halosky.Proxy.interfaceImpl.Customer;
import com.halosky.Proxy.interfaces.IBuyCar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author YangHuan
 * @Date 2018/12/26 19:24
 **/
public class Test {
    public static void main(String[] args){

        // 目标代理类
        Customer customer = new Customer();

        //目标代理对象，通过该对象来调用其方法
        InvocationHandler invocationHandler = new DynamicProxy(customer);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象
         * 第一个参数: handler.getClass().getClassLoader() 我们这里使用handler这个了类的classLoader对象来加载我们的代理对象
         * 第二个参数: customer.getClass().getInterfaces() 这里我们为代理对象提供的接口是真实对象所实行的接口，
         * 这里的意义是:表示我要代理的是该真实对象，这样我们就可以调用这组接口中的方法了
         * 第三个参数: handler 将这个代理对象关联到了上方的InvocationHandler 这个对象上
         */
        Class<?>[] clazz =customer.getClass().getInterfaces();
        System.out.println(clazz[0].getName());
        //invocationHandler.getClass().getClassLoader()
        IBuyCar buyCar = (IBuyCar)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),customer.getClass().getInterfaces(),
                invocationHandler);
        buyCar.buyCar();
    }

   public void  testStaticProxy(String[] args){
        Customer customer = new Customer();
        customer.setCash(50000);
        BuyCarProxy buyCarProxy = new BuyCarProxy(customer);
        buyCarProxy.buyCar();
    }

    public void testDynamicProxy(){
        // 目标代理类
        Customer customer = new Customer();

        //目标代理对象，通过该对象来调用其方法
        InvocationHandler invocationHandler = new DynamicProxy(customer);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象
         * 第一个参数: handler.getClass().getClassLoader() 我们这里使用handler这个了类的classLoader对象来加载我们的代理对象
         * 第二个参数: customer.getClass().getInterfaces() 这里我们为代理对象提供的接口是真实对象所实行的接口，
         * 这里的意义是:表示我要代理的是该真实对象，这样我们就可以调用这组接口中的方法了
         * 第三个参数: handler 将这个代理对象关联到了上方的InvocationHandler 这个对象上
         */

        IBuyCar buyCar = (IBuyCar)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),customer.getClass().getInterfaces(),
                invocationHandler);
        buyCar.buyCar();

    }

}
