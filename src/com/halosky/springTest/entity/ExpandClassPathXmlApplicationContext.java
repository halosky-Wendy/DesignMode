package com.halosky.springTest.entity;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExpandClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public ExpandClassPathXmlApplicationContext(String... paths){
        super(paths);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("HALOSKY_HOME");
    }
}
