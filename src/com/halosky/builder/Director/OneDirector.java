package com.halosky.builder.Director;

import com.halosky.builder.entity.Product;
import com.halosky.builder.interfaceImpl.ConcreateBuilder;

/**
 *  建造者
 * @Author YangHuan
 * @Date 2018/12/15 14:55
 **/
public class OneDirector {

    public Product concreateBuilder(ConcreateBuilder concreateBuilder){
        concreateBuilder.builderBasic();
        return concreateBuilder.builderProduct();
    }

}
