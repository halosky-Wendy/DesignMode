package com.halosky.Adapter.interfaceImpl;

import com.halosky.Adapter.interfaces.BigPort;
import com.halosky.Adapter.interfaces.SmallPort;

/**
 * @Author YangHuan
 * @Date 2018/12/21 15:42
 **/
public class SmallToBig implements BigPort {

    private SmallPort smallPort;

    public SmallToBig(SmallPort smallPort){
        this.smallPort = smallPort;
    }

    @Override
    public void userBigPort() {
        this.smallPort.userSmallPort();
    }
}
