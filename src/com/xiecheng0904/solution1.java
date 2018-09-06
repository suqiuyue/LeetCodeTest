package com.xiecheng0904;

import java.util.Scanner;

/**
 * @data 2018/9/4 18:54
 */
public class solution1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        System.out.println(getNum(num));
    }

    public static int getNum(long n){
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
