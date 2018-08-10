package com.leaning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sqy on 2018/8/10.
 */
public class EnterUtil {
    public static void main(String[] args){
        //singleImport();
        //lineImport();
        //lineInt();
        multiline();

    }

    /**
     * 输入一个字符串或数字，按回车结束输入
     */
    public static void singleImport(){
        Scanner sc = new Scanner(System.in);
        //String str = sc.next();
        int str = Integer.parseInt(sc.next());
        System.out.println(str);
    }

    /**
     * 输入一行字符串，按回车结束输入
     */
    public static void lineImport(){

       /*方法一：
        StringBuffer stringBuffer = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine().trim();
            if (str.equals("")){
                break;
            }
            stringBuffer.append(str);
        }
        System.out.println(stringBuffer.toString());*/
        //方法二：
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (str != null && !str.equals("")){
            str = sc.nextLine();
        }
        System.out.println(str);
    }

    /**
     * 输入一行数值，用空格隔开，按回车结束输入
     */

    public static void lineInt(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numstr = str.split(" ");
        int[] nums = new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            nums[i] = Integer.parseInt(numstr[i]);
        }
        for (int i:nums) {
            System.out.println(i);
        }
    }

    /**
     * 输入多行数字
     */
    public static void multiline(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();


    }
}
