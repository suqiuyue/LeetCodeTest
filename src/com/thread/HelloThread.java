package com.thread;

/**
 * Created by sqy on 2018/6/1.
 */
public class HelloThread extends Thread{

    /*  ThreadLocal保证每个线程中的count是各自独立的，即每个线程中都有一个局部变量count
        static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };

    public static int num(){
        count.set(count.get()+1);
        return count.get();
    }
    */


    static int count = 0;
    public static int num(){
        count++;
        return count;
    }

    public void run(){
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+","+num());
        }
    }
    public static void main(String[] args) throws InterruptedException{

        Thread thread1 = new Thread(new HelloThread());
        Thread thread2 = new Thread(new HelloThread());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
