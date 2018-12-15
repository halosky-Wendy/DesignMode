package com.halosky.Observer.interfaces;

/**
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObServer()方法时，观察者的update()方法会被回调
 */
public interface ObServer {
    public void update(String msg);

}
