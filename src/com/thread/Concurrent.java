package com.thread;

/**
 * Created by sqy on 2018/9/21.
 */
public class Concurrent extends Thread {
    public  int num = 0;

    public static void main(String[] args) {
        Concurrent concurrent = new Concurrent();
        concurrent.start();
        System.out.println(concurrent.functionA());
    }
    public int functionA(){
        Thread athread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    num += i;
                }
            }
        };

        return num ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            num += i;
        }
        functionA();
    }
}
