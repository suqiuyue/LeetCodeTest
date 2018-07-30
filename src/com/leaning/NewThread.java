package com.leaning;

/**
 * Created by sqy on 2018/7/26.
 */
public class NewThread implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("newthread is running...");
            try {
                //设置超时等待状态
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        //初始化状态
        Thread thread = new Thread(new NewThread());
        //就绪状态
        thread.start();
        while (true){
            System.out.println("thread is running...");
        }
    }
}
