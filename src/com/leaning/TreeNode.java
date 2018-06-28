package com.leaning;

/**
 * Created by sqy on 2018/5/3.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null ||in == null ||pre.length !=in.length){

            return null;
        }else {

            return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        }

    }

    public TreeNode reConstructBinaryTree(int[] pre,int pre_low,int pre_high,int[] in,int in_low,int in_high){
        if(pre_low>pre_high || in_low>in_high){
            return null;
        }

        TreeNode root = new TreeNode(pre[pre_low]);

        for(int i=in_low;i<=in_high;i++){

                if(pre[pre_low] == in[i]){

                    root.left = reConstructBinaryTree(pre,pre_low+1,pre_low-in_low+i,in,in_low,i-1);
                    root.right = reConstructBinaryTree(pre,pre_low-in_low+i+1,pre_high,in,i+1,in_high);

                }

        }

        return root;
    }
}
