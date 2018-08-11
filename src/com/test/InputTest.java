package com.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @data 2018/8/11 18:43
 */
public class InputTest {
    public static void main(String[] args){
        long duishu =  singleNum(1,Math.pow(10.0,5.0));
        System.out.println(multiNum(duishu,1,1000));
    }

    /**
     * 输入指定范围的一个数n
     * @param min
     * @param max
     * @return
     */
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

    /**
     * 输入n个数字
     * @param params
     * @return
     */
    public static ArrayList<Long> multiNum(long... params){
        Scanner sc = new Scanner(System.in);
        boolean isInviod = true;
        ArrayList<Long> listforReturn = new ArrayList<>();
        while (isInviod) {
            String str = sc.nextLine();
            String[] numstr = str.split(" ");
            if (numstr.length == params[0]) {
                ArrayList<Long> list = new ArrayList<>();
                for (int i = 0; i < numstr.length; i++) {
                    long cache = Long.parseLong(numstr[i]);
                    if (cache >= params[1] && cache <= params[2]) {
                        list.add(cache);
                    }else{
                        System.out.println("args number invalid");
                        break;
                    }
                }
                if (list.size() == params[0]) {
                    return list;
                }else{
                    System.out.println("args number invalid");
                }
            }else{
                System.out.println("args number invalid");
            }
        }
        return listforReturn;
    }
}
