package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by sqy on 2018/4/2.
 */
public class FindReverse {
    public static void main(String[] args){

        /*Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split("");
        int[] nums = new int[array.length];
       // int[] nums =new int[]{10,20,30,40,50};
        baoji(5,100,nums);*/

        /*Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split("-");
        System.out.println(compare(array.toString()));*/

        String date = "2018-04-01";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(compare(input));
    }

    public static void baoji(int n,int m,int[] nums){
        int num =0;
        Boolean flag = false;
        for(int i=0;i<nums.length;i++){
            num =num +nums[i];
            if(num == m){
                flag = true;
                System.out.println("perfect");
                break;
            }
        }

        if(flag=false){
            System.out.println("good");
        }
    }

    public static boolean compare(String  targetDate){
        boolean flag = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date current = sdf.parse(sdf.format(new Date()));
            Date target = sdf.parse(targetDate);
            int result = target.compareTo(current);
            if(result>0){
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
