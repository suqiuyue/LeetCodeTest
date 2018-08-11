package com.offerTest;


import com.leaning.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *  回溯法练习
 */
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

       /*BackTrack backTrack = new BackTrack();
       TreeNode node1 = new TreeNode(3);
       TreeNode node2 = new TreeNode(4);
       TreeNode node3 = new TreeNode(5);
       TreeNode node4 = new TreeNode(6);
       TreeNode node5 = new TreeNode(7);
       node1.left = node2;
       node1.right = node3;
       node2.left = node4;
       node2.right = node5;
       backTrack.FindPath(node1,14);*/

       BackTrack backTrack = new BackTrack();
       int[] nums = new int[]{1,2,3};
      // backTrack.subsets(nums);
        backTrack.permute(nums);
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

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     */
    ArrayList<ArrayList<Integer>> lists1 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || target == 0){
            return lists1;
        }
        findChildPath(root,target,new ArrayList<>());
        System.out.println(lists1);
        return lists1;
    }

    public void findChildPath(TreeNode root,int target,ArrayList<Integer> list){
        target = target - root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null){
            lists1.add(new ArrayList<>(list));
        }
        if (root.left != null){
            findChildPath(root.left,target,list);
        }
        if (root.right != null) {
            findChildPath(root.right, target, list);
        }
        list.remove(list.size()-1);
    }

    /**
     * 给一个数组，求这个数组的所有子集，包括空集，但不能包含重复子集。
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        getSubsets(nums,0,new ArrayList<>(),lists);
        System.out.println(lists);
        return lists;
    }

    private void getSubsets(int[] nums, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if (start < 0){
            return;
        }else {
            lists.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]){ //若nums数组中包含了重复数字，则当遍历到有重复子集时，不处理直接跳过。
                    continue;
                }
                list.add(nums[i]);
                getSubsets(nums,i+1,list,lists);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 给定一个数组，返回所有的排列组合
     */
    public ArrayList<ArrayList<Integer>> permute(int[] nums){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(nums.length == 0){
            return lists;
        }
        getPermute(nums,new ArrayList<>(),lists);
        System.out.println(lists);
        return lists;
    }

    private void getPermute(int[] nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if (list.size() == nums.length){
            lists.add(new ArrayList<Integer>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])){ //list中如果包含了数组中的元素，则跳过这个元素继续往后遍历。
                    continue;
                }
                list.add(nums[i]);
                getPermute(nums,list,lists);
                list.remove(list.size()-1);
            }
        }
    }
}
