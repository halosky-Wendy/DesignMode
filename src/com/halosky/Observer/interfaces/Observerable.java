package com.halosky.Observer.interfaces;


/**
 * 抽象被观察者接口
 */
public interface Observerable {

    public void register(ObServer o);

    public void remote(ObServer o);

    public void notifyObServer();

}
