package com.halosky.builder;

import com.halosky.builder.Director.OneDirector;
import com.halosky.builder.entity.Product;
import com.halosky.builder.interfaceImpl.ConcreateBuilder;

/**
 * @Author YangHuan
 * @Date 2018/12/15 15:00
 **/
public class Builder {
    public static void main(String[] args){
        OneDirector oneDirector = new OneDirector();
        ConcreateBuilder concreateBuilder = new ConcreateBuilder();
        Product product = oneDirector.concreateBuilder(concreateBuilder);
        System.out.println(product);
    }
}
