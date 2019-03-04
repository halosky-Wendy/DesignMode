package com.halosky.prototypes;

import java.io.*;

/**
 * @Author YangHuan
 * @Date 2019/1/23 16:37
 **/
public class Wukong implements Cloneable, Serializable {

    private String name;
    private Integer age;

    public Stick stick = new Stick();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream= null;
        ObjectInputStream objectInputStream = null;
        Wukong wukong1 = null;
        try {
             byteArrayOutputStream = new ByteArrayOutputStream();
             objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

             byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
             objectInputStream = new ObjectInputStream(byteArrayInputStream);
             wukong1 = (Wukong)objectInputStream.readObject();
            return wukong1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wukong1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
