package com.offerTest;


import com.leaning.TreeNode;

import java.util.*;

/**
 * Created by sqy on 2018/7/23.
 */
public class Solution {

    public static void main(String[] args){

        int[][] array = new int[4][4];
        Solution solution = new Solution();
       // solution.reOrderArray(new int[]{1,2,3,4,5,6,7});

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        solution.printList(solution.Merge1(null, n2));//2
        solution.printList(solution.Merge1(n1, null));//1
        n1.next = n3;
        n3.next = n5;
        n2.next = n4;
        n4.next = n6;
        n6.next = n1;

        solution.printList(solution.Merge1(n1,n2));

    }

    public static class ListNode {
        ListNode next = null;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 1、在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {

        if (array == null || array[0].length <= 0 || array.length <= 0){
            return false;
        }

        boolean result = false;
        int rows = array.length;
        int colums = array[0].length;

        int row = 0;
        int colum = colums -1;

        while (row < rows && colum >=0){
            if (array[row][colum] < target){
                row++;
            }else if(array[row][colum] > target){
                colum--;
            }else {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 2、请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    public String replaceSpace(StringBuffer str) {

        StringBuffer str2 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
             char c = str.charAt(i);
             if (c == ' ') {
                 str2.append("%20");
             }else {
                 str2.append(c);
             }
        }
        return str2.toString();
    }

    /**
     *  3、输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<ListNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            ListNode currentNode = stack.pop();
            list.add(currentNode.val);
        }

        return list;

    }



    /**
     * 4、输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }else {
           return rebuild(pre,0,pre.length-1,in,0,in.length-1);
        }
    }

    private TreeNode rebuild(int[] pre, int pre_low, int pre_high, int[] in, int in_low, int in_high) {

        if (pre_low > pre_high || in_low > in_high){
            return null;
        }
        TreeNode root = new TreeNode(pre[pre_low]);

        for (int i = 0; i < in_high; i++) {
            if (in[i] == pre[pre_low]){
                root.left = rebuild(pre,pre_low+1,pre_low+i-in_low,in,in_low,i-1);
                root.right = rebuild(pre,pre_low+i-in_low+1,pre_high,in,i+1,in_high);
            }
        }

        return root;
    }

    /**
     * 5、把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0){
            return 0;
        }

        int min = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]){
                min = array[i+1];
            }
        }
        return min;
    }

    /**
     * 6、大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
     * F(n)={0,1,F(n-1)+F(n-2)}
     */

    public int Fibonacci(int n){
        if (n <= 0){
            return 0;
        }
        if (n ==1){
            return 1;
        }

        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i=2;i <= n;i++){
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }

        return fn;
    }

    public int Fibonacci1(int n) {
        if (n <= 0){
            return 0;
        }
        if (n ==1|| n == 2){
            return 1;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }

    /**
     * 7、一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */

    public int JumpFloor(int target) {

        int f1 = 1;
        int f2 = 2;
        int fn = 0;

        if (target <=2){
            return target;
        }

        for (int i = 3; i < target; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public int JumpFloor1(int target) {

        if (target <= 2){
            return target;
        }

        return JumpFloor1(target-1)+JumpFloor1(target-2);
    }

    /**
     * 8、一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */

    public int JumpFloorII(int target) {
        if (target <= 2){
            return target;
        }

        return 2*JumpFloorII(target-1);
    }

    /**
     * 9、我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    public int RectCover(int target) {
        if (target <= 0){
            return 0;
        }

        if (target ==1){
            return 1;
        }
        if (target == 2){
            return 2;
        }

        return RectCover(target-1)+RectCover(target-2);
    }

    /**
     * 10、输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */

    public int NumberOf1(int n) {
        int count =0;
        while (n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }

    /**
     * 11、给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 思路：考虑底数和指数为正数、负数和0的情况
     */

    public double Power(double base, int exponent) {
        double result = 1.0;

        if ( exponent == 0){
            return result;
        }

        if (base == 0.0){
            return 0.0;
        }

        if (exponent < 0){
            result = 1/power1(base,-exponent);
        }else {
            result = power1(base,exponent);
        }
        return result;
    }

    public static double power1(double base,int exponent){
        double result = 1.0;

        if(base != 0 && exponent != 0){
            while (exponent !=0){
                result *= base;
                exponent--;
            }
        }
        return result;
    }

    /**
     * 12：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * 思路：新建一个数组，存奇数
     */

    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 0){
            return;
        }

        int[] newarray = new int[array.length];
        int count1 = 0;

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1){
                newarray[count1++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0){
                newarray[count1++] = array[i];
            }
        }

        for (int i = 0; i <array.length; i++) {
            array[i] =newarray[i];
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     *  13、输入一个链表，输出该链表中倒数第k个结点。
     */

    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || head.next == null|| k == 0){
            return null;
        }

        ListNode firstnode = head;
        ListNode laternode = head;

        for (int i = 0; i < k-1; i++) {
            if (firstnode.next != null) {
                firstnode = firstnode.next;
            }else {
                return null;
            }
        }

        while (firstnode.next != null){
            firstnode = firstnode.next;
            laternode = laternode.next;
        }

        return laternode;
    }

    /**
     * 14、输入一个链表，反转链表后，输出新链表的表头。
     */

    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null){
            return  head;
        }

        ListNode node = head;

        node = ReverseList(node.next);

        head.next.next = head;
        head.next = null;

        return node;
    }

    /**
     * 15、输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */

    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                list1.next = Merge(list1.next,list2);
                return list1;
            }else {
                list2.next = Merge(list1,list2.next);
                return list2;
            }
        }

        return null;
    }

    public ListNode Merge1(ListNode list1,ListNode list2) {//????
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode node = null;
        if (list1.val < list2.val){
            node = list1;
            list1 = list1.next;
        }else {
            node = list2;
            list2 = list2.next;
        }

        while (list1 !=null && list2 != null){
            if (list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null){
            node.next = list1;
        }
        if (list2 != null){
            node.next = list2;
        }

        return node.next;
    }

    public void printList(ListNode head){
        while (head!= null){
            if (head.next != null){
                System.out.println(head.val +"->");
            }else {
                System.out.println(head.val);
            }
            head = head.next;
        }
        System.out.println("");
    }

    /**
     * 16、输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */

    /*public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null){
            return false;
        }


    }*/

}
