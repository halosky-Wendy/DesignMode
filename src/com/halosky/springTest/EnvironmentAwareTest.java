package com.halosky.springTest;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @Author YangHuan
 * @Date 2019/3/4 18:09
 **/
public class EnvironmentAwareTest implements EnvironmentAware {


    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment= environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
