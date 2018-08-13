package com.JinRitoutiao0812;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 今日头条第4题输入
 * @data 2018/8/12 10:47
 */
public class Solution4 {
    public static void main(String[] args){
        long num = singleNum(1e5);
        System.out.println(multiNum(num, (long) 1e9));
    }

    public static long singleNum(double max){
        Scanner sc = new Scanner(System.in);
        boolean isInviod = true;
        long num = 0;
        while (isInviod) {
            num = sc.nextLong();
            if (num <= max) {
                return num;
            } else{
                System.out.println("input error try again");
            }
        }
        return num;
    }

    public static ArrayList<ArrayList<Long>> multiNum(long... params){
        Scanner sc = new Scanner(System.in);
        boolean isInviod = true;
        ArrayList<ArrayList<Long>> lists = new ArrayList<>();
        while (isInviod) {
            String str = sc.nextLine();
            String[] numstr = str.split(" ");
            ArrayList<Long> list = new ArrayList<>();
            if (numstr.length == params[0]) {
                for (int i = 0; i < numstr.length; i++) {
                    long cache = Long.parseLong(numstr[i]);
                    if (cache <= params[1]){
                        list.add(cache);
                    }else {
                        System.out.println("args number invalid !");
                    }
                }
            }else{
                System.out.println("args number invalid");
            }
            if (list != null && list.size()!= 0){
                lists.add(new ArrayList<Long>(list));
            }
            if (lists.size() == 2) {
                return lists;
            }
        }
        return lists;
    }
}
