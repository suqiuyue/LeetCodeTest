package com.sort;

import java.util.Arrays;

/**
 * Created by sqy on 2018/5/23.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] input={9,1,2,4,5,8};
        System.out.println(Arrays.toString(quicksort(input,0,input.length-1)));
    }

    public static int position(int[] arr,int low,int high) {

        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置

        return low;

    }

    public static int[] quicksort(int[] a,int low,int high){
        if(low<high){
            int point = position(a,low,high);
            quicksort(a,low,point);
            quicksort(a,point+1,high);
        }
        return a;
    }



}
