package com.search;

/**
 * Created by sqy on 2018/6/27.
 */
public class BinarySearch {

    public static void main(String[] args){
        int[] src= new int[]{1,3,5,7,8,9};
        System.out.println(search(src,0,src.length-1,5));
    }


    public static int search(int[] src,int low,int high,int point){
        int middle = (high + low)/2;
        while (low <= high){
            if(point < src[middle]){
              // high = middle-1;
                search(src,low,middle-1,point);
            }else if(point> src[middle]){
                //low = middle+1;
                search(src,middle+1,high,point);
            }else if(point == src[middle]){
                return middle;
            }
        }

        return -1;
    }
}
