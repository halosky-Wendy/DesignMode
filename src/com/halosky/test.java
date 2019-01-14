package com.halosky;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YangHuan
 * @Date 2018/12/14 15:02
 **/
public class test {

    public static void main(String[] args){
        List<String> testList = new ArrayList();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        testList.add("4");
        List<String> targetList = new ArrayList<>();
        targetList.add("2");
        targetList.add("8");
        if(testList.containsAll(targetList)){
            System.out.println("包含");
        }

    }

}
