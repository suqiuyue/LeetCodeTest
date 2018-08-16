package com.huawei0815;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

/**
 * Created by sqy on 2018/8/16.
 */
public class Solution21 {

    public static int[] count = new int[8];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag && sc.hasNext()){
            String str = sc.nextLine();
            if (str.equals("-1,-1")){
                break;
            }else {
                getNums(str);
            }
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println("["+(i+12)+","+(i+12+1)+")"+":"+count[i]);
        }
    }

    public static void getNums(String str) {
        String[] strings = str.split(",");
        int start = Integer.parseInt(strings[0])-12;
        int end = Integer.parseInt(strings[1])-12;
        if (start < 0){
            start = 0;
        }
        if(end > 8){
            end = 8;
        }
        while (start < end){
            count[start]++;
            start++;
        }
    }
}
