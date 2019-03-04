package com.halosky.Proxy.ManualProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author YangHuan
 * @Date 2019/1/21 22:16
 **/
public class Test {

    public static void main(String[] args){
        Mediary mediary = new Mediary();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoFang.class);
        enhancer.setCallback(mediary);

        XiaoFang xiaoFang = (XiaoFang)enhancer.create();
        xiaoFang.findLove();

    }

}
