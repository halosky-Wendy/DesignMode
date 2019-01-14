package com.halosky.Proxy.interfaceImpl;

import com.halosky.Proxy.interfaces.IBuyCar;

/**
 * @Author YangHuan
 * @Date 2018/12/26 19:26
 **/
public class Customer implements IBuyCar {

    private int cash;    // 购车款

    @Override
    public void buyCar() {
        System.out.println("买了一辆兰博基尼-->"+cash+"元");
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
