package com.structure;

import java.util.Stack;

/**
 * Created by sqy on 2018/6/28.
 */
public class stack {
    public static void main(String[] args){
        String src = "hello";
        Stack stack = new Stack();

        for(int i = 0;i< src.length();i++){
                char c = src.charAt(i);
                stack.push(c);
            }

        for (int i = 0;i<src.length();i++){
            if(!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }
        }

    }


