package com.halosky.java8;

import com.halosky.java8.entity.Product;
import com.halosky.java8.interfaces.IFunction;

/**
 * @Author YangHuan
 * @Date 2019/3/2 11:27
 **/
public class Test {



    @org.junit.Test
    public void test(){

        Product product = new Product();
        product.setProductName("堕落虾");

        IFunction iFunction = product::getProductName;

        String productName = iFunction.convert();
        System.out.println(productName);
    }


}
