package com.offerTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackTrack {
    public static void main(String[] args){
       /* Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
                list.add(Integer.parseInt(strings[i]));
        }

        BackTrack backTrack = new BackTrack();
        backTrack.combine(list.get(0),list.get(1));*/
        BackTrack backTrack = new BackTrack();
        backTrack.combine(4,2);
    }
    /**
     * 输入两个整数 n和k，从1到n中选择k个数字的组合。
     */

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < 1 || k > n){
            return null;
        }
        backtrack(n,k,1,new ArrayList<>());
        System.out.println(lists);
        return lists;
    }

    public void backtrack(int n,int k,int start,List<Integer> list){
        if (k < 0){
            return;
        }else if (k == 0){
            lists.add(new ArrayList<>(list));
        }else {
            for (int i = start; i <= n ; i++) {
                list.add(i);
                backtrack(n,k-1,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

}
