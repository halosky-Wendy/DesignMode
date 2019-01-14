package com.halosky.prototype.entity;

/**
 * @Author YangHuan
 * @Date 2018/12/21 15:08
 **/
// 如果要克隆就必须实现Cloneable接口
public class Person implements Cloneable {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getCopy(){
        try {
            return (Person) this.clone();
        }catch (Exception e){
            System.out.println("该拷贝类没有实现Cononeable接口"+e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // 如果没有实现cloneable接口就会抛出异常
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
