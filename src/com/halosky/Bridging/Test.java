package com.halosky.Bridging;

import com.halosky.Bridging.abstracts.AreaA;
import com.halosky.Bridging.core.AreaA1;
import com.halosky.Bridging.core.AreaA2;
import com.halosky.Bridging.interfaceImpl.AreaB1;
import com.halosky.Bridging.interfaces.Qiao;

/**
 * @Author YangHuan
 * @Date 2018/12/21 16:20
 **/
public class Test {

    public static void main(String[] args){
        AreaA a = new AreaA2();
        AreaA a1 = new AreaA1();

        Qiao qiao = new AreaB1();

    }

}
