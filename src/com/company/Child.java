package com.company;

/**
 * Created by sqy on 2018/3/16.
 */
public class Child implements IAdd {
    private Base base;
    private long sum;

    public Child(){
        base = new Base();
    }
    public void add(int number){
        base.add(number);
        sum += number;
    }

    public void addAll(int[] numbers){
        base.addAll(numbers);
        for(int i=0;i<numbers.length;i++){
            sum +=numbers[i];
        }
        System.out.println(sum);
    }

    public long getSum(){
        return sum;
    }
}
