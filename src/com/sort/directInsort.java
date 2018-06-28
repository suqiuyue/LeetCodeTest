package com.sort;

import java.util.Arrays;

/**
 * Created by sqy on 2018/6/27.
 */
public class directInsort {
    public static void main(String[] args){
        int[] src = new int[]{57,68,59,52,62,43};

       // System.out.println(Arrays.toString(insort(src)));
        System.out.println(Arrays.toString(sort(src)));
    }

    public static int[] insort(int[] src){

        for(int i =1;i<src.length;i++){

            for(int j = i-1;j>=0;j--){
                if(src[j]>src[j+1]){
                    int temp = src[j];
                    src[j] = src[j+1];
                    src[j+1] = temp;
                }
            }

        }
        return src;
    }

   /* public static int[] binaryinsort(int[] src){
        int low =0;
        int high = src.length-1;
        int middle = (low + high)/2;
        for(int i =0;i< src.length-1;i++){
            int temp = src[i];
            while (low < high){
                if(src[i] < middle){
                    high = middle-1;
                }else if(src[i] > middle){
                    low = middle+1;
                }

            }
        }

    }*/
    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
        }
        return a;
    }

}
