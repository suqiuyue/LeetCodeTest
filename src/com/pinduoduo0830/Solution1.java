package com.pinduoduo0830;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @data 2018/8/30 21:00
 */
public class Solution1 {
    public static void main(String[] args) {

        //System.out.println(minBattle());
        combineWord();
    }
    public static long minBattle(){
        Scanner sc = new Scanner(System.in);
        long hp = sc.nextLong();
        long normal = sc.nextLong();
        long buffer = sc.nextLong();

        long noPower = hp / (normal) == 0 ? hp / normal : hp / (normal) + 1;
        long Power = hp / (buffer) * 2;

        hp %= buffer;
        if (hp > normal){
            Power += 2;
        }else if (hp <= normal){
            Power++;
        }
        return Math.min(noPower,Power);
    }

     public static String combineWord(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int num = Integer.valueOf(strings[0]);
        int length = Integer.valueOf(strings[1]);
         ArrayList<String> list = new ArrayList<>();
         for (int i = 0; i < num; i++) {
             String str1 = sc.nextLine();
             list.add(str1);
         }
         return str;
     }
}
