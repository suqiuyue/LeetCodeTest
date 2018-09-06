package com.beike0903;

import java.util.Scanner;

/**
 * @data 2018/9/3 19:04
 */
public class solution1 {

    public static void main(String[] args) {

       // System.out.println(getNum());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] string = str.split(" ");
        long n = Integer.parseInt(string[0]);
        long m = Integer.parseInt(string[1]);
        solution(n,m);

    }

   /* public static int getNum(){


        if (n < 1 || n > (long) Math.pow(10.0,9.0)){
            return 0;
        }
        if (m < 1 || m > (long) Math.pow(10.0,9.0)){
            return 0;
        }
       int count =  countNum(n,m,0);
        return count;
    }*/

    public static int countNum(long n,long m,int count){
        if (n >= m){

            return count;
        }else {
            panding(n,m,count);
        }
        return count;
    }

    public static int A(long n,long m,int count){
        long n1 = n * 2;
        if (m == n1){
            return count;
        } else if (n1 > m){
            while (n1>m){
                n1--;
                count++;
            }
        }else {
            n1 *= 2;
        }
        return count;
    }
    public static void panding(long n,long m,int count){
        long mod = m % n;
        if (mod >1){
            long n1 = n * 2;
           countNum(n,m,++count);
        }else if(mod == 1){
            n = n - 1;
            count++;
            if (m % n > 1){
                countNum(n,m,count);
            }
        }else if(mod == 0){
            long chu = m / n;
            n = (long) Math.pow(n,chu);
            count += chu;
            countNum(n,m,count);
        }
    }

    public static void solution(long n,long m){

        if (n >= m){
            System.out.println(n-m);
        }else {
            int count = 0;
            while (n < m){
                if (n % 2 == 0){
                    n *= 2;
                }else {
                    n -= 1;
                    n *= 2;
                    count += 2;
                }
                count += n-m;
                System.out.println(count);
            }
        }
    }
}
