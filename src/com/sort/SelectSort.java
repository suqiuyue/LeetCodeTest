package com.sort;

import java.util.Arrays;

/**
 * Created by sqy on 2018/6/28.
 */
public class SelectSort {

    public static void main(String[] args){
        int[] src = new int[]{57,68,59,52,62,43};
        System.out.println(Arrays.toString(sort(src)));
    }
    public static int[] sort(int[] src){
        for(int i = 0;i<src.length;i++){
            int min = i;
            for (int j = i+1; j<src.length;j++){
                if(src[j]<src[min]){
                    min = j;
                }
            }

            if(min !=i){
                int temp = src[i];
                src[i] = src[min];
                src[min] = temp;
            }
        }
        return src;
    }
}
