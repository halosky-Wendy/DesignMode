package com.halosky.factory;

/**
 * @Author YangHuan
 * @Date 2019/1/23 16:14
 **/
public interface Test {

    public static void main(String[] args){
        CartFactory cartFactory = new CartFactory();
        cartFactory.createCart("BWM");
    }


}
