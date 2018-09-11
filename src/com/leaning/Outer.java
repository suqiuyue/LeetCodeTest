package com.leaning;

/**
 * Created by sqy on 2018/9/10.
 */
public class Outer {
    private static int shared = 100;
    private int b = 200;
    public void getNum(int num){
        num += shared;
    }

    public static void getNum1(){
        return;
    }
    static class StaticInner{
        private static int shared1 = 100 + shared;
        private int shared2 = 200;
        private int getSum(){
            return shared1 + shared2;
        }
    }

    private void test(){
        StaticInner inner = new StaticInner();
        inner.getSum();

        Inner inner1 = new Inner();
        inner1.getNumber();
    }

    class Inner{
        int a = 100;
        private void getNumber(){
            return;
        }
    }

    public static void main(String[] args) {
        StaticInner inner = new StaticInner();
        inner.getSum();

        Outer outer = new Outer();
        Inner inner1 = outer.new Inner();
        inner1.getNumber();
    }
}
