package com.sort;

/**
 * Created by sqy on 2018/5/23.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] input={9,6,8,4,5};

        quicksort(input,input[0],input.length);
        for(int a :input){
            System.out.print(a);
        }
    }

    public static int position(int[] a,int low,int high){

        int point = a[low];
        while (low < high){
            if(a[high]>=point){
                --high;
            }else {
                a[low] = a[high];
            }
            if (a[low]<=point){
                ++low;
            }else {
                a[high] = a[low];
            }
        }
        a[low] =point;
        return low;
    }

    public static void quicksort(int[] a,int low,int high){
        if(low<high){
            int point = position(a,low,high);
            quicksort(a,low,point-1);
            quicksort(a,point+1,high);
        }
    }


}
