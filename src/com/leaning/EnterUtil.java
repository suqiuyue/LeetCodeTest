package com.leaning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sqy on 2018/8/10.
 */
public class EnterUtil {
    public static void main(String[] args){
   /*     singleImport();
        lineImport();
        lineInt();
        multiline();*/
//        single(5,13,14);
        long duishu =  one(1,Math.pow(10.0,5.0));
        System.out.println(single(duishu,1,1000));
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

    }

    /**
     * 输入多行数字
     */
    public static void multiline(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true){
            String string = scanner.nextLine();
            if (string.equals("")) {
                break;
            }
            list.add(Integer.parseInt(string));
        }
        System.out.println(list);
    }


    public static long one(double min,double max){
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
    public static ArrayList<Long> single(long... params){
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
