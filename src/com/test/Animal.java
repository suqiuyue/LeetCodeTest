package com.test;

/**
 * Created by sqy on 2018/7/5.
 */
public class Animal {

    private String fly;
    private String type;


    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Animal(){
        System.out.println("Animal 构造函数。。。");
    }

    public void getfly(){
        System.out.println("Animal 实例函数。。。");
    }

    static {
        System.out.println("Animal静态代码块。。。");
    }
}
