package com.structure;

import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by sqy on 2018/6/28.
 */
public class stack {
    public static void main(String[] args){
        /*StringTest src = "hello";
        Stack stack = new Stack();
        StringTest src1="";
        for(int i = 0;i< src.length();i++){
                char c = src.charAt(i);
                stack.push(c);
            }

            while (!stack.isEmpty()){
                char a = (char) stack.pop();
                 src1= src1 + a;
            }

            System.out.println(src1);

            test1();*/
        System.out.println(Expression());

        }

    public static void test(){
        String[] months = {"January","February","March","April","May","June","July","August","September","Octomber","November"};

        Stack stack = new Stack();
        for (int i = 0; i < months.length; i++) {
            stack.push(months[i]);
        }
        //System.out.println("");
        while (!stack.isEmpty()){
            System.out.println( stack.pop());
        }
    }

    public static void test1(){
        String[] months = {"January","February","March","April","May","June","July","August","September","Octomber","November"};
        Vector vector = new Vector();
        for (int i = 0; i < months.length; i++) {
            vector.add(months[i]+" ");
        }

        while (!vector.isEmpty()){
            System.out.println(vector.firstElement());
            vector.removeElement(vector.firstElement());
        }

    }

    public static boolean Expression(){
        boolean flag = false;
        String src = "2.3 + 23 / 12 + (3.14159 * 0.24)";
        Stack stack = new Stack();
        char ch,chx;
        for (int i = 0; i < src.length(); i++) {
            ch = src.charAt(i);
            switch (ch){
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if (!stack.isEmpty()){
                        chx = (char) stack.pop();
                        if (chx !='('){
                            return flag;
                        }
                    }else {
                        return flag;
                    }
                    default:
                        break;
            }
        }
        if (!stack.isEmpty()){
            return flag;
        }

        flag = true;

        return flag;

    }
}


