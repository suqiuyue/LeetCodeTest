package com.company;

import java.util.Arrays;

/**
 * Created by sqy on 2018/3/26.
 */
public class insertSort {
    public static void main(String[] args){
        int[] arrary={12,32,5,14,45,29};

        /*insert(arrary);
        System.out.println("直接插入排序："+ Arrays.toString(arrary));
        Baninsert(arrary);
        System.out.println("折半插入排序："+ Arrays.toString(arrary));*/
        Xiinsert(arrary);
        System.out.println("希尔插入排序："+ Arrays.toString(arrary));
    }

    public static void insert(int[] arr){
        for(int i=1;i<arr.length;i++){
            int tmp = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]<tmp){
                    break;
                }else {
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }

        }
    }


    public static void Baninsert(int[] arr){
        for(int i=1;i<arr.length;i++){
            int tmp =arr[i];
            int low = 0;
            int high = i-1;
            int mid ;
            int j ;
            if(low<=high){
                mid = (high+low)/2;
                if(tmp<arr[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            for(j=i-1;j>=low;j--){
                if(tmp < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

    }

    public static void Xiinsert(int[] arr){

        for(int dk=arr.length/2;dk>=1;dk = dk/2){
            for(int i=dk;i<arr.length;++i){
                int tmp = arr[i];
                for(int j=i-dk;j>=0;j=j-dk){
                   if(tmp<arr[j]){
                       arr[j+dk] = arr[j];
                       arr[j] = tmp;
                   }
                }
            }
        }
    }


}
