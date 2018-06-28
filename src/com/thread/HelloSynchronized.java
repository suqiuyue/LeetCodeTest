package com.thread;

/**
 * Created by sqy on 2018/6/1.
 */
public class HelloSynchronized {
    private int counter;
    public synchronized void incr(){
        counter++;
    }
    public synchronized int getCounter(){
        return counter;
    }
}
