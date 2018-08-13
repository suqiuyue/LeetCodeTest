package com.JinRitoutiao0812;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 今日头条第2题
 * @data 2018/8/12 11:36
 */
public class Solution2 {
    public static void main(String[] args){
        long m = singleNum(Math.pow(2,16));
    }
    public static long singleNum(double max){
        Scanner sc = new Scanner(System.in);
        boolean isInviod = true;
        long num = 0;
        while (isInviod) {
            num = sc.nextLong();
            if ( num <= max) {
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
            String[] numstr = str.split(",");
            ArrayList<Long> list = new ArrayList<>();
            if (numstr.length == 2) {
                long x = Long.parseLong(numstr[0]);
                long y = Long.parseLong(numstr[1]);
                if (x >=params[1] && x <= params[2] && y >=params[3] && y<= params[4]){
                    list.add(x);
                    list.add(y);
                }else {
                    System.out.println("args number invalid !");
                }
            }else{
                System.out.println("args number invalid");
            }
            lists.add(new ArrayList<Long>(list));
            if (lists.size() == params[0]) {
                return lists;
            }
        }
        return lists;
    }
}
