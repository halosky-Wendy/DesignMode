package com.halosky.Adapter.interfaceImpl;

import com.halosky.Adapter.interfaces.BigPort;
import com.halosky.Adapter.interfaces.SmallPort;

/**
 * @Author YangHuan
 * @Date 2018/12/21 15:45
 **/
public class BigToSmall implements SmallPort {

    private BigPort bigPort;

    public BigToSmall(BigPort bigPort){
        this.bigPort = bigPort;
    }


    @Override
    public void userSmallPort() {
        bigPort.userBigPort();
    }
}
