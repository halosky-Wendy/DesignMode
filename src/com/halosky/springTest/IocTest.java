package com.halosky.springTest;

import com.halosky.springTest.entity.A;
import com.halosky.springTest.entity.B;

/**
 * @Author YangHuan
 * @Date 2019/3/2 11:46
 **/
public class IocTest {

    public static void main(String[] args){
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml;");
//        User user = (User) classPathXmlApplicationContext.getBean("user");
//
//        UserInterface userInterface = user::getName;
        A a = null;
        if(a instanceof B){
            System.out.println("shide");
        }

    }



    @FunctionalInterface
    public interface UserInterface{
        String getName();
    }

}
