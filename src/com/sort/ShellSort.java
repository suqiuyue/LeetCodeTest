package com.sort;

import java.util.Arrays;

/**
 * Created by sqy on 2018/6/28.
 */
public class ShellSort {
    public static void main(String[] args){
        int[] src = new int[]{57,68,59,52,62,43};
        System.out.println(Arrays.toString(sort1(src)));
    }
    public static int[] shellsort(int[] src){
        for(int dk = src.length/2;dk>=1;dk= dk/2){
            for(int i = 0;i<dk;i++){
                if(src[i]> src[i+dk]){
                    int temp= src[i];
                    src[i] = src[i+dk];
                    src[i+dk] = temp;
                }

            }
        }

        return src;
    }

    public static int[] sort(int[] arr){//该算法不对，当步长为1时，不是直接插入算法，而是冒泡算法

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
            for (int j = 0; (j+gap) < arr.length; j++){     //使用当前gap进行组内插入排序
                for(int k = j; (k+gap)< arr.length; k += gap){
                    if(arr[k] > arr[k+gap]) {
                        int temp = arr[k+gap];      //交换操作
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                        System.out.println("    Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
        return arr;
    }

    public static int[] sort1(int[] a){ //未看懂为什么要这么设计？
        int d = a.length;
        while(true){
            d = d / 2;
            for(int x=0;x<d;x++){
                for(int i=x+d;i<a.length;i=i+d){
                    int temp = a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
            if(d == 1){
                break;
            }
        }

        return a;
    }

}

