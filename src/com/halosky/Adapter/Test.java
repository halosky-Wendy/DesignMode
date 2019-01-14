package com.halosky.Adapter;

import com.halosky.Adapter.interfaceImpl.BigToSmall;
import com.halosky.Adapter.interfaceImpl.SmallToBig;
import com.halosky.Adapter.interfaces.BigPort;
import com.halosky.Adapter.interfaces.SmallPort;

/**
 * @Author YangHuan
 * @Date 2018/12/21 15:39
 **/
public class Test {

    public static void main(String[] args){
//        SmallPort smallPort = new SmallPort() {
//            @Override
//            public void userSmallPort() {
//                System.out.println("使用的是小口");
//            }
//        };
//        BigPort bigPort = new SmallToBig(smallPort);
//        bigPort.userBigPort();

        BigPort bigPort = new BigPort() {
            @Override
            public void userBigPort() {
                System.out.println("大口转小口使用");
            }
        };

        BigToSmall bigToSmall = new BigToSmall(bigPort);
        bigToSmall.userSmallPort();
    }
}
