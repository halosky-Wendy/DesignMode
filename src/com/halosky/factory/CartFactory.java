package com.halosky.factory;

import com.halosky.factory.interfaceImpl.BWM;
import com.halosky.factory.interfaceImpl.BenZo;
import com.halosky.factory.interfaces.Cart;

/**
 * @Author YangHuan
 * @Date 2019/1/23 16:23
 **/
public class CartFactory {

    private Cart cart = new BenZo();

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public Cart createCart(String name){
        if(name.equals("BWM")){
            System.out.println("返回宝马");
            return new BWM();
        }
        if(name.equals("BenZo")){
            System.out.println("返回奔驰");
            return new BenZo();
        }
        System.out.println("找不到车辆信息");
        return  cart;
    }

}
