package com.halosky.builder.interfaces;

import com.halosky.builder.entity.Product;

/**
 * 抽象构建
 */
public interface BuilderInterface {

    public void builderBasic();

    public void builderWalls();

    public void roofed();

    /**
     *  建造实际产品
     * @return
     */
    public Product builderProduct();

}
