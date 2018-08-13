package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sqy on 2018/4/4.
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>(){};
    static ArrayList<Integer> list2 = new ArrayList<Integer>();
    int result=0;
    int count =0;

    public static void main(String[] args){

        /*ArrayList<Integer> list = new ArrayList<Integer>();
        Solution4 so = new Solution4();
        so.push(1);
        so.push(2);
        list.add(so.pop());
        so.push(3);
        list.add(so.pop());
        list.add(so.pop());
        so.push(4);
        list.add(so.pop());
        so.push(5);
        list.add(so.pop());
        System.out.println(list);*/

        /*int[] list ={3,4,5,1,2};
        System.out.println(minNumberInRotateArray(list));*/

        /*int num=3;
        System.out.println(Fibonacci(num));*/
        System.out.println(JumpFloor(4));


    }

    public  void push(int node){
        stack1.push(node);
    }

    public int pop(){

        Stack<Integer> clone = (Stack<Integer>) stack1.clone();
        while (!clone.isEmpty()){
            stack2.push(clone.pop());
        }

        for(int i=0;i<=count;i++){
            if(i==count){
                result =stack2.pop();
                count++;
                return result;
            }
            stack2.pop();
        }

        return result;
    }

    public static int minNumberInRotateArray(int [] array) {

        int tmp =0;
        for(int i=1;i<=array.length;i++){
            tmp = array[i];
            if(tmp < array[i-1]){
                return tmp;
            }
        }

        return tmp;
    }

    public static int Fibonacci(int n){

        int f0=0;
        int f1=1;
        int fn=0;
        int[] result ={0,1};
        if(n<2){
            return result[n];
        }

        for(int i=2;i<=n;i++){
            fn =f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static int JumpFloor(int target) {

        if(target <0){
            return 0;
        }

        if(target<=2){
            return target;
        }
        int fn=0;
            for(int i=3;i<=target;i++){
               fn = JumpFloor(i-1)+JumpFloor(i-2)+1;
            }
            return fn;
    }


}
