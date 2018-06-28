package com.company;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by sqy on 2018/4/7.
 */
public class Number1 {

     public static void main(String[] args){

            hagkh();
         }

    private static void hagkh() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num > 1000 || num < 1) {
            num = scanner.nextInt();
        }

        long[] xGroup = new long[num];
        for (int i = 0; i < num; i++) {
            long x = scanner.nextLong();
            while (x >= Long.MAX_VALUE || x < 2) {
                x = scanner.nextLong();
           }
            xGroup[i] = x;

        }

        A:for (int i = 0; i < xGroup.length; i++) { //从最小的数开始

            B:for (int j = 1; j <= xGroup[i]; j++) { //比如 10
                if (xGroup[i] % j == 0) {
                    long cache = xGroup[i] % j;
                    if (cache % 2 != 0) {
                        System.out.println(cache + " " + j * 2);
                        continue A;
                    }
                }

            }
            System.out.println("NO");
        }
    }

}
