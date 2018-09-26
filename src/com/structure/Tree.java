package com.structure;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.misc.*;

import java.util.*;
import java.util.Queue;

/**
 * Created by sqy on 2018/7/17.
 */
public class Tree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("二叉树="+node1.val);

        Tree tree = new Tree();
        ArrayList<ArrayList<Integer>> list=tree.printZ(node1);

        System.out.println(list.toArray());




    }

    /**
     * 算法1：根据前序序列和中序序列，构造二叉树。
     * @param first
     * @param middle
     * @return
     */

    public TreeNode getNewTree(int[] first,int[] middle){

        if (first == null || middle == null || first.length != middle.length){
            return null;
        }else {
            return reConstructBinaryTree(first,first[0],first.length-1,middle,middle[0],middle.length-1);
        }
    }

    public TreeNode reConstructBinaryTree(int[] first, int first_low, int frist_high, int[] middle, int middle_low, int middle_high){

        if (first_low > frist_high || middle_low > middle_high){
            return null;
        }

        TreeNode root = new TreeNode(first[first_low]);

        for (int i = middle_low; i <= middle_high ; i++) {
            if (first[first_low] == middle[i]){
                root.left = reConstructBinaryTree(first,first_low+1,first_low+i-middle_low,middle,middle_low,i-1);
                root.right = reConstructBinaryTree(first,first_low+i-middle_low+1,frist_high,middle,i+1,middle_high);
            }
        }

        return root;
    }

    /**
     * 算法2：输入一颗二叉树，输出这颗树的镜像
     * 思路：（1）递归（2）利用栈保存二叉树
     */

    public TreeNode getMirrorTree(TreeNode root){
        if (root == null){
            return null;
        }

        TreeNode mirror = new TreeNode(root.val);
        if (mirror.left != null || mirror.right != null){
                TreeNode tmpNode = mirror.left;
                mirror.left = mirror.right;
                mirror.right = tmpNode;
        }

        if (mirror.left != null){
            getMirrorTree(mirror.left);
        }
        if (mirror.right != null){
            getMirrorTree(mirror.right);
        }

        return mirror;
    }

    /**
     * 算法3：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * 思路：先从A的根节点开始判断，是否与B根节点的值相同，若相同则判断其节点结构是否与B的结构相同；若不相同，在依次从左节点开始遍历，若还是没有再找右节点。
     */

    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = doesTree1HasTree2(root1,root2);
            }
            if (!result){
                result = HasSubtree(root1.left,root2.left);
            }
            if (!result){
                result = HasSubtree(root1.right,root2.right);
            }
        }

        return result;

    }

    public boolean doesTree1HasTree2(TreeNode root1,TreeNode root2){
        if (root2 == null){ //若B已经遍历完了，说明是A的子结构
            return true;
        }
        if (root1 == null){
            return false;
        }

        if (root1.val != root2.val){
            return false;
        }

        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
    }

    /**
     * 算法4：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 思路：（1）利用两个list来模拟队列（2）使用队列
     */

    public ArrayList<Integer> printNode(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null){
            return list;
        }
        queue.add(root);

        while (queue.size() != 0) {
            TreeNode tmpNode = queue.remove(0);

            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
            list.add(tmpNode.val);
        }

        return list;
    }

    public ArrayList<Integer> printNode1(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null){
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curreentNode = queue.poll();

            if (curreentNode.left != null){
                queue.offer(curreentNode.left);
            }

            if (curreentNode.right != null){
                queue.offer(curreentNode.right);
            }

            list.add(curreentNode.val);
        }
        return list;
    }

    /**
     * 算法5：分行从上到下打印二叉树
     * 思路：（1）使用两个变量：一个保存当前层中的节点数量，另一个保存下一层未打印的节点数量
     *      （2）递归
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null){
            return lists;
        }

        queue.offer(pRoot);

        int currentNum = 1;
        int nextNum = 0;

        ArrayList<Integer> list;
        while (!queue.isEmpty()){
            int tmp = currentNum;
            list = new ArrayList<>();
            for (int i = 0; i < tmp; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                    ++nextNum;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    ++nextNum;
                }
                list.add(node.val);
                --currentNum;
            }
            if (currentNum == 0){
                lists.add(list);
                currentNum = nextNum;
                nextNum = 0;
            }
        }
        return lists;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list){
        if (root == null){
            return;
        }

        if (list.size() < depth){
            list.add(new ArrayList<Integer>());
        }

        list.get(depth-1).add(root.val);

        depth(root.left,depth+1,list);
        depth(root.right,depth+1,list);
    }


    /**
     * 算法6：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * 思路：利用两个栈分别保存正序和反序的节点。
     */

    public ArrayList<ArrayList<Integer> > printZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null){
            return lists;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);

        int level = 1;

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (level % 2 != 0){
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    if (node != null){
                        list.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }

                if (!list.isEmpty()){
                    lists.add(list);
                    level++;
                }
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    if (node != null){
                        list.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }

                if (!list.isEmpty()){
                    lists.add(list);
                    level++;
                }
            }
        }

        return lists;
    }

    /**
     * 算法7：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 思路：(1)递归：后序序列中，最后一位为根节点，并且排序二叉树中根节点的左子树都比它小，右子树都比他大。
     */

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0){
            return false;
        }
        if (sequence.length == 1){
            return true;
        }

        return verify(sequence,0,sequence.length-1);
    }

    public static boolean verify(int[] sequence,int low,int high){
        int root = sequence[high];
        int i ;
        for (i = 0; i < high; i++) {
            if (sequence[i] > root){
                break;
            }
        }

        int j ;
        for ( j = i; j < high; j++) {
            if (sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if (i > low){
            left = verify(sequence,low,i-1);
        }

        boolean right = true;
        if (i < high){
            right = verify(sequence,i,high-1);
        }

        return left && right;
    }

    /**
     * 算法8：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     * 思路：
     */

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if (root == null || target == 0){
            return null;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        find(lists,list,root,num,target);

        return lists;
    }

    public void find(ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> list,TreeNode node,int num,int target){

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            list.add(currentNode.val);
            if (!list.isEmpty()){
                lists.add(list);
            }
            num  += currentNode.val;
            if (num != target){
                if (currentNode.left != null){
                    find(lists,list,currentNode.left,num,target);
                }
                if (currentNode.right != null){
                    find(lists,list,currentNode.right,num,target);
                }

                list.remove(currentNode);
            }
        }
    }

}
