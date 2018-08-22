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

       /* solution.printList(solution.Merge1(null, n2));//2
        solution.printList(solution.Merge1(n1, null));//1*/
        n1.next = n3;
        n3.next = n5;
        n2.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(solution.FindFirstCommonNode(n1,n2));
       // solution.printList(solution.Merge1(n1,n2));

       // int[][] IOtest = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        /*int[][] IOtest = {{1,2},{3,4}};
        ArrayList<Integer> list = solution.printMatrix(IOtest);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
       // System.out.println(solution.printMatrix(IOtest));
        /*int[] IOtest = {2,6,5,8,10,9,7};
        solution.VerifySquenceOfBST(IOtest);*/
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
       // solution.FindPath(node1,22);

       // System.out.println(solution.TreeDepth(node1));
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.nextLine();
        System.out.println(solution.Permutation(str));*/
       char[] ch = new char[]{'a','b','t','g','c','f','c','s','j','d','e','h'};
       char[] ch1 = new char[]{'b','f','c','e'};
      // hasPath(ch,3,4,ch1);

        int[] price = {7,5,4,3,2,1};
       // System.out.println( maxProfit(price));
        int[] nums = {1,-2,3,10,-4,7,2,-5};
       /* int num = solution.MoreThanHalfNum_Solution2(nums);
        System.out.println(num);*/
      //  solution.GetLeastNumbers_Solution(nums,4);

      //  solution.FindGreatestSumOfSubArray(nums);
        /*String str = "abca";
        System.out.println(solution.Permutation(str));*/
        int[] n = {2,4,3,6,3,2,5,5};
        solution.FindNumsAppearOnce(n,new int[1],new int[1]);
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

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null){
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val){
            result = hasstructure(root1,root2);
        }
        if (!result){
            result = HasSubtree(root1.left,root2);
        }
        if (!result){
            result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    private boolean hasstructure(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        return hasstructure(root1.left,root2.left) && hasstructure(root1.right,root2.right);
    }

    /**
     * 17、操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }

    /**
     * 18、输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean isRow = false;
        boolean isAdd = true;
        int margin = 0;
        int nums = 0;
        int row = 0,column = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (columns > 1){
            isRow = !isRow;
        }
        while (nums < rows * columns){
            list.add(matrix[row][column]);
            //System.out.println(matrix[row][column]);
            nums++;
            if (isRow){
                column +=isAdd?1:-1;
                if (column == (columns-1) - margin || column == margin){
                    isRow = ! isRow;
                }
            }else{
                row +=isAdd?1:-1;
                if (row == (rows-1) - margin || row == margin){
                    isAdd = ! isAdd;
                    isRow = ! isRow;
                }
                if (row == margin){
                    row++;
                    column++;
                    margin++;
                }
            }
        }
        return list;
    }

    /**
     * 19、定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    class Stack1{
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minstack = new Stack<>();
        public void push(int node) {
            stack.push(node);
            if (minstack.isEmpty() || node < minstack.peek()){
                minstack.push(node);
            }else {
                minstack.push(minstack.peek());
            }
        }
        public void pop() {
            stack.pop();
            minstack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int min() {
            return minstack.peek();
        }
    }

    /**
     * 20、输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA == null || popA == null || pushA.length <= 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length;) {
            stack.push(pushA[i++]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 21、从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        queue.offer(root);


        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
    /**
     * 22、输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence.length == 0){
            return false;
        }

        return Verify(sequence,0,sequence.length-1);

    }
    public boolean Verify(int[] sequence,int low,int high){
        if (low > high){
            return true;
        }
        int root = sequence[high];
        int i = low;
        for (; i < high; i++) {
            if (sequence[i] > root){
                break;
            }
        }
        int j = i;
        for (; j < high; j++) {
            if (sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if (i > 0){
            left = Verify(sequence,low,i-1);
        }
        boolean right = true;
        if (i < high){
            right = Verify(sequence,i,high-1);
        }
        return left && right;
    }
    /**
     * 23、输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     */

    public ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null){
            return lists;
        }
        path.add(root.val);
        target -=root.val;
        if (target == 0 && root.left == null && root.right == null){
            lists.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return lists;
    }

    /**
     * 24、输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */

    public ArrayList<String> Permutation(String str) {
        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        if (str == null && str.length() == 0){
            return list1;
        }
        char[] chars = str.toCharArray(); //将字符串转换成char数组
        getPermutation(chars,new ArrayList<>(),lists);

        char[] ch1 = new char[chars.length];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < ch1.length; j++) {
                ch1[j] = lists.get(i).get(j);
            }
            String string = new String(ch1); //char数组转换成string字符串
            list1.add(string);
        }
        Collections.sort(list1);
        return list1;
    }

    private void getPermutation(char[] chars, ArrayList<Character> list, ArrayList<ArrayList<Character>> lists) {
        if (chars.length == list.size()){
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])){
                continue;
            }
            list.add(chars[i]);
            getPermutation(chars,list,lists);
            list.remove(list.size()-1);
        }
    }

    /**
     * 25、请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     */

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null|| matrix.length == 0){
            return false;
        }
        /*char[][] m = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = matrix[j+i];
            }
        }*/
        boolean path = false;

        return path;
    }
    /**
     * 26、leetcode 121
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int min = prices[0];    //记录最低购买价格
        int maxPrice = 0;       //记录最高收益
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i],min);
            maxPrice = Math.max(maxPrice,prices[i]-min);
        }
        return maxPrice;
    }

    /**
     * 27、数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     * 如果不存在则输出0。
     */

    public int MoreThanHalfNum_Solution(int [] array) { //原始算法,时间复杂度为O(n2)
        if (array.length == 0 || array == null){
            return 0;
        }else if (array.length == 1){
            return array[0];
        }
        int tmp ;
        int length = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            int count = 1;
            for (int j = i + 1;j < array.length; j++) {
                if (array[j] == array[i]){
                    count++;
                    if (count > length){
                        return tmp;
                    }
                }
            }
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution1(int [] array) { //使用hashmap保存数字和重复的次数
        if (array.length == 0 || array == null){
            return 0;
        }else if (array.length == 1){
            return array[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int count = map.get(array[i]);
                map.replace(array[i],++count);
                if (map.get(array[i]) > array.length / 2){
                    return array[i];
                }
            }

        }
        return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array.length == 0 || array == null){
            return 0;
        }else if (array.length == 1){
            return array[0];
        }
        int count = 1;
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == tmp){
                ++count;
            }else {
                --count;
            }
            if (count == 0){
                tmp = array[i];
                count = 1;
            }
        }
        //验证tmp的值是否满足重复次数大于数组长度的一半
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tmp) count++;
        }
        if (count * 2 > array.length) return tmp;
        return 0;
    }

    /**
     * 28、输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k <= 0 || input.length <= 0 || k > input.length) return list;
        quicksort(input,0,input.length-1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        System.out.println(list);
        return list;
        }

    public static int[] quicksort(int[] input,int left,int right) {

        if (left < right){
            int point = position(input,left,right);
            quicksort(input,left,point-1);
            quicksort(input,point+1,right);
        }
        return input;
    }

    private static int position(int[] input, int left, int right) {
        int pivot = input[left];
        while (left < right){
            while (left < right && pivot < input[right]){
                --right;
            }
            input[left] = input[right];
            while (left < right && pivot > input[left]){
                ++ left;
            }
            input[right] = input[left];
        }
        input[left] = pivot;
        return input[left];
    }

    /**
     * 29、给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
     *    例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {//使用DP求解
        if (array.length <= 0){
            return 0;
        }
        int tmp = array[0];    //记录子序列的和
        int maxNum = array[0]; //记录最大值
        for (int i = 1; i < array.length; i++) { //到第i个值之前，求子序列的最大值
            tmp = Math.max(tmp+array[i],array[i]);
            maxNum = Math.max(tmp,maxNum);
        }
        return maxNum;
    }

    /**
     * 30、输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */

    public int TreeDepth(TreeNode root) { //树的深度即为栈的深度
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int rigth = TreeDepth(root.right);
        return Math.max(left,rigth)+1;
    }
    /**
     * 31、在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.
     */

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i), ++count);
            }else {
                map.put(str.charAt(i),1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 32、求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int Sum_Solution(int n) {
         int num = n;
         boolean flag = (num > 0)&& ((num += Sum_Solution(n-1))>0); //利用递归和短路与
         return num;
    }
    /**
     * 33、输入两个链表，找出它们的第一个公共结点。
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        if (pHead1 == null){
            return pHead2;
        }
        if (pHead2 == null){
            return pHead1;
        }
        Map<ListNode,Integer> map = new HashMap<>();
        int index = 0;
        while (pHead1 != null){
            index ++;
            map.put(pHead1,index);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            if (map.containsKey(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 34、输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 35 、统计一个数字在排序数组中出现的次数。
     */
    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k){
                count++;
            }
            if (i > k){
                break;
            }
        }
        return count;
    }

    /**
     * 36、一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
     */

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length <= 0 || array == null){
            return;
        }
        int count = 0;
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < array.length; i++) {
           if (!map.containsKey(array[i])){
               map.put(array[i],1);
           }else {
               count = map.get(array[i]);
               map.replace(array[i],count,count+1);
           }
        }
        for (int i = 0; i < array.length ; i++) {
            if (map.get(array[i]) == 1){
                if (num1[0] == 0){
                    num1[0] = array[i];
                }else {
                    num2[0] = array[i];
                }
            }
        }
        System.out.println("num1[0]="+num1[0]+",num2[0]="+num2[0]);
    }
    /**
     * 37、把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    public int GetUglyNumber_Solution(int index) {

        return 0;
    }
}
