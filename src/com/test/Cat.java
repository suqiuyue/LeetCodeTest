package com.test;

/**
 * Created by sqy on 2018/7/5.
 */
public class Cat extends Animal {

    private StringTest run;

    public StringTest getRun() {
        return run;
    }

    public void setRun(StringTest run) {
        this.run = run;
    }

    public Cat(){
        System.out.println("Cat 构造函数。。。");
    }

    public void run(){
        System.out.println("Cat 实例函数。。。");
    }

    static {
        System.out.println("Cat静态代码块。。。");
    }

    public void getfly(){
        System.out.println("Cat 实例函数。。。");
    }
}
