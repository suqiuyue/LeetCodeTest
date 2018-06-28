package com.thread;

/**
 * Created by sqy on 2018/6/1.
 */
public class HelloThread extends Thread{

    private static int counter=0;

    public static void main(String[] args) throws InterruptedException{

        //HelloThread thread = new HelloThread();
        //thread.start();

        int num =1000;
        Thread[] threads =new Thread[num];
        for (int i=0;i<num;i++){
            threads[i] = new HelloThread();
            threads[i].start();
        }

        for(int i =0;i<num;i++){
            threads[i].join(); //主线程结束了，子线程还没结束时，让主线程等待子线程结束后再退出
        }

        System.out.println(counter);
    }


    public void run(){
        //System.out.println("thread name:"+Thread.currentThread().getName());
        //System.out.print("hello");

        for(int i=0;i<1000;i++){
            counter++;
        }
    }

}
