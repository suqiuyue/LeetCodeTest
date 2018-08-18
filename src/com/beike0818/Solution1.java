package com.beike0818;

        import java.util.ArrayList;
        import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args){

        long n =  one(2,Math.pow(10.0,5.0));
        ArrayList<Long> list = line(n,0, (long) Math.pow(10.0,4.0));
        //  System.out.println(list);
        System.out.println(sort(list));

    }
    public static long one(double min,double max){
        Scanner sc = new Scanner(System.in);
        long num = 0;
        while (true) {
            num = sc.nextLong();
            if (num >= min && num <= max) {
                return num;
            } else{
                System.out.println("input error number,try again!");
            }
        }
    }
    public static ArrayList<Long> line(long... params){
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            String[] string = str.split(" ");
            if (string.length == params[0]){
                ArrayList<Long> list = new ArrayList<>();
                for (int i = 0; i < string.length; i++) {
                    long num = Integer.parseInt(string[i]);
                    if (num >= params[1] && num <= params[2]){
                        list.add(num);
                    }else{
                        System.out.println("input error number,try again!");
                    }
                }
                return list;
            }else{
                System.out.println("input error number,try again!");
            }
        }
    }

    public static long sort(ArrayList<Long> array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size()-i-1; j++) {
                if (array.get(j)>array.get(j+1)){
                    long cache = array.get(j);
                    array.set(j,array.get(j+1));
                    array.set(j+1,cache);
                }
            }
        }
        long x = 0;
        for (int i = 1; i < array.size(); i++) {
            x = x+array.get(i);
        }
        return x;
    }

}
