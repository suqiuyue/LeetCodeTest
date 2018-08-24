package com.structure;

/**
 * Created by sqy on 2018/8/24.
 */
public class Singleton {
    public static void main(String[] args) {

        Singleton singleton = getInstance1();
    }

    private Singleton(){}
    /*双重锁检查
    private volatile static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }*/


    private static class Holder{ //静态内部类实现单例
        private final static Singleton instance1 = new Singleton();
    }

    public static Singleton getInstance1(){
        return Holder.instance1;
    }

}
