package com.company;

/**
 * Created by sqy on 2018/3/16.
 */
public class Base implements IAdd{
    private static final int MAX_NUM = 1000;
    private int[] arr = new int[MAX_NUM];
    private int count;
    public void add(int number){
        if(count<MAX_NUM){
            arr[count++]=number;
        }
    }

    public void addAll(int[] numbers){
        for(int num:numbers){
            add(num);
        }
    }
}
