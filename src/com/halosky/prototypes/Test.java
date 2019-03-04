package com.halosky.prototypes;

/**
 * @Author YangHuan
 * @Date 2019/1/23 16:36
 **/
public class Test {

    public static void main(String[] args){
        Wukong wukong = new Wukong();
        wukong.setName("halosky");
        wukong.setAge(18);

        wukong.stick.setName("金箍棒");
        try {
            Wukong copyWukong = (Wukong) wukong.clone();
            System.out.println(copyWukong.stick.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
