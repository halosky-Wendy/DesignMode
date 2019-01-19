package com.halosky.Proxy.ManualProxy.staticProxy;

import java.lang.reflect.Proxy;

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

        Person p = (Person)Proxy.newProxyInstance(XiaoFang.class.getClassLoader(),XiaoFang.class.getInterfaces(),matchmaker);
        p.getLove();

      /*  byte[] data = ProxyGenerator.generateProxyClass("com.sun.proxy.$Proxy0",new Class[]{Person.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/$Proxy0.class");
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        System.out.println(p.getClass().getName());         //com.sun.proxy.$Proxy0

    }
}
