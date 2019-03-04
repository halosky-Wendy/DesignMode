package com.halosky.prototypes;

import java.io.Serializable;

/**
 * @Author YangHuan
 * @Date 2019/1/23 16:41
 **/
public class Stick implements  Cloneable, Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
