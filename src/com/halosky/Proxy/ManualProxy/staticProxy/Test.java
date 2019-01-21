package com.halosky.Proxy.ManualProxy.staticProxy;

import com.halosky.Proxy.ManualProxy.halosky.HaloClassLoader;
import com.halosky.Proxy.ManualProxy.halosky.HaloProxy;

/**
 * @Author YangHuan
 * @Date 2019/1/19 16:55
 **/
public class Test {

    public static void main(String[] args){
//        Matchmaker matchmaker = new Matchmaker(new XiaoFang());
//        matchmaker.getLove();
        /*
        运行结果:
                我来帮你找对象
                我叫小芳
         */
        Matchmaker matchmaker = new Matchmaker(new XiaoFang());

        Person p = (Person) HaloProxy.newProxyInstance(new HaloClassLoader()
                ,XiaoFang.class.getInterfaces(),matchmaker);
        p.getLove();


    }
}
