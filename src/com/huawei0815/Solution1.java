package com.huawei0815;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给一个字符串，去除重复的字符，其他顺序不变。
 * @data 2018/8/15 18:34
 */
public class Solution1 {
    public static void main(String[] args){
        System.out.println(getStr());
    }
    public static String getStr(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        if (ch == null || ch.length == 0){
            return null;
        }
        for (int i = 0; i < ch.length; i++) {
            if (list.contains(ch[i])|| ch[i] == ' '){
                continue;
            }
            list.add(ch[i]);
        }
        char[] ch1 = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ch1[i] = list.get(i);
        }
        String string = new String(ch1);
        return string;
    }

}
