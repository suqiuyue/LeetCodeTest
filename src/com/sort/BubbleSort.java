package com.sort;

import java.util.Arrays;


/**
 * Created by sqy on 2018/5/23.
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] input={9,6,2,4,5,8};

       // bubble(input);
       // bubble2(input);

       /* for(int i=0;i<input.length;i++){
            bubble3(input,i);
        }

        System.out.print(Arrays.toString(input));*/

      System.out.println(Arrays.toString(quicksort(input,0,input.length-1)));

    }

    public static void bubble(int[] a){ //基本的冒泡算法

        for(int i=0;i<a.length;){
           boolean flag = false;
            for(int j = i+1;j< a.length;j++){
                if(a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;

                    flag = true;
                }
            }

            if(!flag){
                System.out.println(Arrays.toString(a));
                return;
            }
        }

    }

    public static void bubble2(int[] a){ //优化冒泡算法，不再遍历之前已经排好序的数
        int num = a.length;
        for(int i=0;i<a.length;){
            for (int j=1;j<num;j++){
                if(a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;

                }
            }
            num = num -1;
            if(num == 0){
                break;
            }
        }
        System.out.print(Arrays.toString(a));
    }

    public static int[] bubble3(int[] a,int num){ //双向遍历

        for(int i =num;i<a.length-1-num;i++){
            int tmp =a[i];
            if(a[i]>=a[i+1]){
                a[i] = a[i+1];
                a[i+1] =tmp;
            }
        }
        num++;
        for(int j = a.length-num;j> 0+num;j--){
            int tmp1 = a[j];
            if(a[j] <a[j-1]){
                a[j] = a[j-1];
                a[j-1] =tmp1;
            }
        }
        return a;

    }

    public static int[] quicksort(int[] src,int low,int high){
        if (low < high){
            int point = position(src,low,high);
            quicksort(src,low,point-1);
            quicksort(src,point+1,high);

        }

        return src;
    }
    public static int position(int[] src,int low,int high){
        int point = src[low];
        while (low<high){
            while (low<high && src[high]>=point){
                high--;
            }
            src[low] = src[high];
            while (low < high && src[low] <= point){
                low++;
            }
            src[high] = src[low];
        }

        src[low] = point;
        return low;
    }

}
