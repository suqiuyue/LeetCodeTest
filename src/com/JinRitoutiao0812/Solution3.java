package com.JinRitoutiao0812;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 今日头条第3题输入
 * @data 2018/8/11 14:34
 */
public class Solution3 {
    public static void main(String[] args){
        long num = singleNum(0,100);
        System.out.println(multiNum(num,0,1000,0, (long) 1e6));
    }

    public static long singleNum(double min,double max){
        Scanner sc = new Scanner(System.in);
        boolean isInviod = true;
        long num = 0;
        while (isInviod) {
            num = sc.nextLong();
            if (num >= min && num <= max) {
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
