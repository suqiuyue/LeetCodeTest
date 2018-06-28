package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sqy on 2018/3/15.
 */
public class Sort {

    public static void main(String[] args){
        /*int[] a={3,1,7,5,2,4,9,6};
        InsertSort(a,8);*/


        /*Sort sort = new Sort();
        sort.findNum(10);*/

        Scanner sc = new Scanner(System.in);
        long number;
        ArrayList<Long>  list = new ArrayList<>();
        while (sc!=null){
            for(int i=1;i<=1000;i++){
                number = sc.nextLong();
                list.add(number);
            }
        }

        long t =list.get(0);
        for(int m =1;m<=list.size();m++){
            count(t,m);
        }

    }

    public static void InsertSort(int[] a, int n){
        for(int i= 1; i<n; i++){
            if(a[i] < a[i-1]){               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j= i-1;
                int x = a[i];        //复制为哨兵，即存储待排序元素
                a[i] = a[i-1];           //先后移一个元素
                while(x < a[j]){  //查找在有序表的插入位置
                    a[j+1] = a[j];
                    j--;         //元素后移
                }
                a[j+1] = x;      //插入到正确位置
            }
            System.out.println(a+","+n+","+i);           //打印每趟排序的结果
        }
    }

    public  static ArrayList<Long> findNum(long num) {
        ArrayList<Long> list = new ArrayList<>();
        long x ,y ;
        if (num % 2 == 0) {
            y = 2;
            x = num / y;
            list.add(x);
            list.add(y);
            System.out.println(list.get(0)+" "+list.get(1));
        } else {
            System.out.println("NO");
        }

        return list;
    }

    public static void count(long t,long num){
        while (t!=0){
            findNum(num);
            t--;
        }
    }
}
