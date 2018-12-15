package com.halosky.builder.interfaceImpl;

import com.halosky.builder.entity.Product;
import com.halosky.builder.interfaces.BuilderInterface;

/**
 *  具体的建造
 * @Author YangHuan
 * @Date 2018/12/15 14:52
 **/
public class ConcreateBuilder implements BuilderInterface {

    private Product product;

    public ConcreateBuilder(){
        product = new Product();
    }

    @Override
    public void builderBasic() {
        product.setBasic("basic 设置完毕");
    }

    @Override
    public void builderWalls() {
        product.setWall("walls 设置完毕");
    }

    @Override
    public void roofed() {
        product.setRoofed("roofed 设置完毕");
    }

    @Override
    public Product builderProduct() {
        return this.product;
    }
}
