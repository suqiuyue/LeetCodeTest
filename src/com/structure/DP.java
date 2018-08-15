package com.structure;

import java.util.Scanner;

/**动态规划：1、将原问题分解为子问题。子问题与原问题的形式相同或类似，只是规模变小了，并且保存子问题的值；
 * 2、确定状态。将和子问题相关的各个变量的一组取值。
 * 3、确定初始状态的取值；
 * 4、确定状态转移方程。
 * Created by sqy on 2018/8/13.
 */
public class DP {

    public static void main(String[] args){
        int[][] a = new int[4][4];
        a[0][0] = 1;
        a[1][0] = 2;
        a[1][1] = 3;
        a[2][0] = 4;
        a[2][1] = 5;
        a[2][2] = 6;
        a[3][0] = 7;
        a[3][1] = 8;
        a[3][2] = 9;
        a[3][3] = 10;
      // calculateByRecall(a);
      //  System.out.println(bottom_up_cut_rod(3));
      //  System.out.println(fib1(6));
       /* String str1 = "abcdbfs";
        String str2 = "acbdwfsd";
        System.out.println(getLCS(str1,str2,str1.length(),str2.length()));
        System.out.println(getLCS1(str1,str2,str1.length(),str2.length()));*/
       int[] num ={1,3,5,4,7,6,9};
        System.out.println(maxLength(num));

    }

    /**
     * 1、枚举：矩阵熄灯问题，矩阵中某个按钮按下即改变状态。请你写一个程序，确定需要按下哪些按钮，恰好使得所有的灯都熄灭。
     */
    static int[][] press = new int[6][8];
    static int[][] puzzle = new int[6][8];

    //根据press中的第一行的状态和puzzle数组，判断press中2~5行的状态
    public static boolean guess(){
        boolean status = false;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 7; j++) {
                press[i+1][j]= (puzzle[i][j]+press[i][j]+
                        press[i][j-1]+press[i][j+1]+press[i-1][j])%2;
            }
        }

        //判断最后一行是否能全部熄灭，如果不能说明第一行按错，需要重新枚举
        for (int j = 1; j < 7; j++) {
            if(puzzle[5][j] !=(press[5][j]+press[5][j-1]+press[5][j+1]+press[4][j])){
                return status;
            }
        }

        status = true;
        return status;
    }

    //枚举press数组中第一行的状态
    public static void enumerate(){
        int j;
        for (j = 1; j < 7; j++) {
            press[1][j] =0;
        }
        while (guess() == false){
            press[1][1]++;
            j=1;
            while (press[1][j]>1){ //进位操作
                press[1][j] = 0;
                j++;
                press[1][j]++;
            }
        }

        return;
    }

    public static void Denginput(){
        Scanner sc = new Scanner(System.in);
        int i,j;
        for (i = 0; i < 6; i++) {
            press[i][0] = press[i][7] =0;
        }
        for (j = 1;j < 7;j++){
            press[0][j] = 0;
        }
        for (i = 1; i < 6; i++) {
            for (j = 1; j < 7; j++) {
                puzzle[i][j] = sc.nextInt();
            }
        }
        enumerate();
        for (i = 1; i < 6; i++) {
            for (j = 1; j < 7; j++) {
                System.out.println(press[i][j]);
            }
        }
    }

    /**
     * 2、有一个由非负整数组成的三角形，第一行只有一个数，除了最后一行之外每个数的左下方和右下方各有一个数。
     从第一行的数开始，每次可以往下或右下走一格，直到走到最后一行，把沿涂经过的数全部加起来。如何走才能使得这个数尽可能的大？
     */


    //回溯解法
    public static int getMaxSum(int[][] a,int i,int j){

        System.out.println("m["+i+"]["+j+"]");
        int max = a[i][j] + (i == a.length-1 ? 0 : Math.max(getMaxSum(a,i+1,j),getMaxSum(a,i+1,j+1)));
        return max;
    }

    public static int calculateByRecall(int[][] a){

        int max = getMaxSum(a,0,0);
        System.out.println("max[0][0]="+max);
        return max;
    }

    //至底向上的递推法
    public static int getMaxSum1(int[][] a,int i,int j){

        System.out.println("m["+i+"]["+j+"]");
        int max = a[i][j] + (i == a.length-1 ? 0 : Math.max(a[i+1][j],a[i+1][j+1]));
        return max;
    }

    public static int calculateByRecall1(int[][] a){
        for (int i = a.length-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = getMaxSum(a,i,j);
            }
        }
        int max = a[0][0];
        System.out.println("max[0][0]="+max);
        return max;
    }

    /**
     * 3、钢条切割问题。给定一段长度为n英寸的钢条和一个价格表p(i)，
     * 求切割钢条的方案，使得销售收益r(n)最大。
     * 注意，如果长度为n英寸的钢条的价格为p(n)足够大，最优解可能不是完全不需要切割。
     */

    //至底向上
    public static int getMaxPrice(int n){
        int[] a ={1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int max = 0;
        if (n <= 1){
            return n;
        }else {
            int max1 = Math.max(getMaxPrice(n),n);
            max = Math.max(max1,1+getMaxPrice(n-1));
        }
        return max;
    }

    private static int bottom_up_cut_rod(int n){
        int[] a ={1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] dp = new int[n+1];

        for(int j=1; j<=n; j++){//从1->n遍历钢条的长度
            int max = 0;
            for(int i=1; i<=j; i++){ //计算从1->n个长度钢条的不同切割方式的最大价格
                max = Math.max(max, a[i-1] + dp[j-i]);
            }
            dp[j] = max;
        }
        return dp[n];
    }
    /**
     * 4、Fibonacci数列
     */

    public static int fib(int n){ //递归法
        return (2 > n) ? n : fib(n - 1) + fib(n - 2);
    }

    //动态规划
    public static int fib1(int n){
        int tmp = 0;
        int n0 = 0;
        int n1 = 1;
        if (n <= 1){
            return n;
        }
        for (int i = 2; i <= n; i++) {
            tmp = n0 + n1;
            n0 = n1;
            n1 = tmp;
        }
        return tmp;
    }

    /**
     * 5、最长公共子序列的长度。
     */

    public static int getLCS(String str1,String str2,int len1,int len2){ //递归算法
        if (len1 == 0||len2 == 0){
            return 0;
        }else if (str1.charAt(len1-1) == str2.charAt(len2-1)){
            return getLCS(str1,str2,len1-1,len2-1) + 1;
        }
        return Math.max(getLCS(str1,str2,len1-1,len2),getLCS(str1,str2,len1,len2-1));
    }


    public static int getLCS1(String str1,String str2,int len1,int len2){//动态规划

        if (len1 == 0|| len2 == 0){
            return 0;
        }

        int[][] result = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    result[i][j] = result[i-1][j-1] + 1;
                }else {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return result[len1][len2];
    }

    /**
     * 6、求一个序列的最长上升子序列的长度。
     */
    public static int maxLength(int[] nums){
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) { //每次求以i为终点的最长子序列的长度
            tmp[i] =1;
            for (int j = 0; j < i; j++) {//求以j为终点的最长子序列的长度
                if (nums[i] > nums[j]){
                    tmp[i] = Math.max(tmp[i],tmp[j]+1);
                }
            }
        }
        int max = tmp[tmp.length-1];
        return max;
    }

    /**
     * 7、有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */
    public static void bankpackage(int m,int n,int[] price,int[] value){

    }

}
