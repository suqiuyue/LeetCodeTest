package com.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sqy on 2018/7/14.
 */
public class LinkedList {

    ListNode head;
    ListNode current;

    public void add(int val){
        if (head ==null){
            head = new ListNode(val);
            current = head;
        }else {
            current.next = new ListNode(val);
            current = current.next;
        }
    }

    public void print(ListNode node){
        if (node == null){
            return;
        }
        current = node;
        while (current !=null){
            System.out.println(current.val);
            current = current.next;
        }

    }
    class ListNode{
        ListNode next; //指针域，指向的下一个元素
        int val; // 数据域

        ListNode sbiling;
        ListNode(int x){
            val = x;
            next = null;
            sbiling = null;
        }
    }

    /**
     *   算法1：找到链表的倒数第n个节点
     *   （1）使用散列表（哈希表）：遍历一次链表，在遍历每个节点的时候分别在散列表中存储<节点位置,节点地址>。
     *       假设链表长度为M，则目标问题转换成为：求链表中正数第M-n+1个节点，也就是返回散列表中主键为M-n+1的值即可
     *   （2）不使用散列表求解问题。思路类似上面的散列表实现思路，不同的是这次是通过两次遍历链表的操作来实现：
     *       第一次遍历链表得到链表的长度M，第二次遍历找到正数第M-n+1个节点.
     *   （3）扫描一次链表就解决问题。定义两个指针都指向链表的表头节点，其中一个节点先移动 n-1 次，
     *       然后两个指针同时开始向后移动，当处于前面的指针移动到表尾节点时，则此时处于后面的指针即是我们需要求取的节点
     */

    public static ListNode findNumMethod1(ListNode node,int n){//利用hashmap来保存链表的指针和数据，可得到链表的长度
        ListNode currentNode = node;
        Map<Integer,ListNode> nodeMap = new HashMap<>();
        for (int i = 0; currentNode!=null; i++) {
            nodeMap.put(i,currentNode);
            currentNode = currentNode.next;
        }
        if (n < 1 || n>nodeMap.size()){
            throw new RuntimeException("输入参数错误！");
        }else {
            return nodeMap.get(nodeMap.size()-n+1);
        }
    }

    public static ListNode findNumMethod2(ListNode node,int n){ //遍历一遍链表得到长度len，计算len-n+1得到倒数第n个节点元素
        int len = 0;
        ListNode currentNode = node;
        while (currentNode!=null){
            len++;
            currentNode = currentNode.next;
        }
        if (n < 1 || n > len){
            throw new RuntimeException("输入参数错误！");
        }else {
            currentNode = node;
            for (int i = 0;i <len-n+1; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }

    public static ListNode findNumMethod3(ListNode node,int n){ //使用两个指针，其移动间隔n-1个，当第一个指针指向链表尾端时，第二个指针指向倒数第n个节点
       if (node == null || n ==0){
           return null;
       }


        ListNode frontNode = node;
        ListNode laterNode = node;
        for (int i = 0; i < n-1; i++) {
            if (frontNode != null){
                frontNode = frontNode.next;
            }else {
                return null;
            }
        }

        while (frontNode != null && frontNode.next != null){
            frontNode = frontNode.next;
            laterNode = laterNode.next;
        }
        return laterNode;
    }



    /**
     * 算法2：查找单链表的中间结点
     * 思路：使用两个指针，快指针移动2步，慢指针移动1步，当快指针指向链表尾端时，慢指针所指的结点即为中间结点
     */

    public static ListNode finfMiddle(ListNode node){
        if(node == null){
            return null;
        }

        ListNode fristNode = node;
        ListNode laterNode = node;

        while (fristNode != null && laterNode !=null){
            fristNode = fristNode.next.next;
            laterNode = laterNode.next;
        }

        return laterNode;

    }

    /**
     * 算法3：如何判断给定的链表是以NULL结尾，还是形成了一个环？
     * （1）使用散列表（哈希表）：从表头开始逐个遍历链表中的每个节点，并检查其是否已经存在散列表中。如果存在则说明已经访问过该节点了，也就是存在环；
     *     如果一直到表尾都没有出现已经访问过的节点，则说明该链表不存在环
     * （2）Floyd环判定算法：使用两个在链表中具有不同移动速度的指针（如：fastNode每次移动两个节点，slowNode每次移动一个节点），
     *     两个指针同时从表头开始移动，如果在某一时刻它们相遇了，则表明该链表存在环。原因很简单：快速移动指针和慢速移动指针将会指向同一位置的唯一可能情况就是整个或者部分链表是一个环
     */


    public static boolean ringmethod1(ListNode node){
        Map<Integer,ListNode> nodeMap = new HashMap<>();
        ListNode currentNode = node;
        for (int i = 0; currentNode!=null ; i++) {
            if (nodeMap.containsValue(currentNode)){
                return true;
            }else {
                nodeMap.put(i,currentNode);
                currentNode = currentNode.next;
            }
        }
        return false;

    }

    public static boolean ringmethod2(ListNode node){
        ListNode frontNode = node;
        ListNode laterNode = node;
        while (laterNode.next !=null && frontNode.next !=null && frontNode.next.next !=null){
            frontNode = frontNode.next.next;
            laterNode = laterNode.next;
        }

        if (frontNode == laterNode){
            return true;
        }

        return false;
    }

    /**
     * 算法4：如何判断给定的链表是以NULL结尾，还是形成了一个环？如果链表中存在环，则求环的长度
     * 思路：先判断是否有环，若有环，从两个指针的相遇点开始计数，继续遍历到下一次两个相遇，得到环的长度
     */


    public static int getLen(ListNode node){
        if (node ==null){
            return 0;
        }

        int len = 0;
        boolean isRing =false;
        ListNode fristNode = node;
        ListNode laterNode = node;

        while (fristNode.next !=null && laterNode.next !=null && fristNode.next.next !=null){
            fristNode = fristNode.next.next;
            laterNode = laterNode.next;
            if (laterNode == fristNode){
                isRing = true;
                break;
            }
        }

        if (isRing){
            laterNode = laterNode.next;
            len++;
            while (laterNode != fristNode){
                laterNode = laterNode.next;
                len++;
            }

        }
        return len;
    }


    /**
     * 算法5：如何判断给定的链表是以NULL结尾，还是形成了一个环？如果链表中存在环，则求环的起始点
     * 思路：先判读是否有环，得到环的长度len。然后让快指针先移动len步，
     * 然后让快、慢两个指针同时移动，当两个指针第一次相遇时，这个点就是环的起始点
     */

    public static ListNode getNode(ListNode node){
        if (node ==null){
         return null;
        }

        int len = getLen(node);
        if (len == 0){
            return null;
        }

        ListNode fristNode = node;
        ListNode laterNode = node;
        for (int i = 0; i < len; i++) {
            fristNode = fristNode.next;
        }

        while (fristNode != null &&laterNode != null){
            fristNode = fristNode.next;
            laterNode = laterNode.next;
            if (laterNode == fristNode){
                return laterNode;
            }
        }

        return null;
    }

    /**
     * 算法6：如何逆置单向链表,返回头指针。
     * 思路：记录当前移动指针的前一个指针和后一个指针
     *
     */
    public static ListNode reverse(ListNode head){
        if (head ==null || head.next ==null){
            return head;
        }

        ListNode currentNode;
        ListNode reverseHead = head;  //记录当前移动指针的后一个指针节点
        ListNode tmpNode = null;   //记录当前移动指针的前一个指针节点

        while (reverseHead !=null){
            currentNode = reverseHead;
            reverseHead = currentNode.next;
            currentNode.next = tmpNode;
            tmpNode = currentNode;
        }
        return tmpNode;
    }

    /**
     * 算法7：求合并两个有序链表之后的新链表，保证新链表也是有序的
     *
     */

    public static ListNode merge(ListNode head1,ListNode head2){
        if (head1 == null||head2 == null){
            return null;
        }
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        ListNode head;

        if (head1.val < head2.val){

            head = head1;
            head1 = head1.next;
        }else {

            head = head2;
            head1 = head1.next;
        }

        while (head1 != null && head2 !=null){
            if (head1.val < head2.val){
                head.next = head1;
                head1 = head1.next;
                head = head.next;
            }else {
                head.next = head2;
                head2 =head2.next;
                head = head.next;
            }
        }

        if (head1 != null){
            head.next = head1;
        }
        if (head2 != null){
            head.next = head2;
        }

        return head;
    }
    /**
     * 算法8：从尾到头打印单链表(非反转链表法)
     * 思路：（1）利用栈，先进后出；（2）递归
     */

    public static void reversePrint(ListNode node){
        if (node == null || node.next == null){
            return ;
        }

        Stack stack = new Stack();
        ListNode currentNode = node;
        while (currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.next;
        }

        while (!stack.isEmpty()){
            currentNode = (ListNode) stack.pop();
            System.out.println(currentNode.val);
        }
        
    }

    public static void reversePrint2(ListNode node){
        if (node == null){
            return;
        }
        ListNode currentNode = node;
        reversePrint(currentNode.next);
        System.out.println(currentNode.val);
    }

    /**
     * 算法9：判断两个单链表相交的第一个交点
     * 思路：（1）利用两个栈，从链表尾部向前比较。由于两个链表相交后，尾部的链表是相同的，从尾部向前比较到最后一位相同的结点即为第一个交点
     *      （2）利用快慢指针，两个链表的长度不一样，先遍历一次得到两个链表的长度len1和len2，第二次遍历时，让长度更长的指针先走len1-len2步，接着同时遍历，找到第一个相同结点即为交点
     */

    public static ListNode getCommonNode1(ListNode head1,ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        while (head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }

        while (head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode node1 = (ListNode) stack1.pop();
            ListNode node2 = (ListNode) stack2.pop();
            if (node1 != node2){
                return node1.next;
            }
        }

        return null;

    }

    public static ListNode getCommonNode2(ListNode head1,ListNode head2){
        if (head1 == null || head2 == null){
            return null;
        }
        int len1 = 0;
        int len2 = 0;

        ListNode currentNode1 = head1;
        ListNode currentNode2 = head2;

        while (currentNode1 != null){
            len1++;
            currentNode1 = currentNode1.next;
        }

        while (currentNode2 != null){
            len2++;
            currentNode2 = currentNode2.next;
        }

        if (len1 > 0 && len2 > 0 && (len1 - len2) > 0){
            for (int i = 0; i < len1-len2; i++) {
                head1 = head1.next;
            }
        }else if (len1 > 0 && len2 > 0 && (len1 -len2) <= 0){
            for (int i = 0; i < len2 -len1; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null && head2 !=null){
            if (head1.val == head2.val){
                return head1;
            }else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return null;
    }

    /**
     * 算法10：在O(1)时间内删除链表的节点
     * 思路：我们知道要删除的结点以及该结点的下一个结点，将下一个节点的值复制给要删除的结点，并删除下一个结点，相当于删除了规定要删除的结点。
     */

    public static void deleteNode(ListNode head,ListNode pointNode){
        if (head == null || pointNode == null){
            return ;
        }
        if (head == pointNode){  // 链表只有一个结点且要删除的是该结点时
            head = null;
            pointNode = null;
        }else if (pointNode.next == null){ //当要删除链表的结点是最后一个结点
            ListNode currentNode = head;
            while (currentNode.next != pointNode){
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            pointNode = null;
        }else {
            ListNode tmpNode = pointNode.next;
            pointNode.val = pointNode.next.val;
            pointNode.next = tmpNode.next;
            tmpNode = null;
        }

    }

    /**
     * 算法11：复制复杂链表，
     * 在复杂链表中，每个结点除了有一个next指针指向下一个结点外，还有一个sbiling指向链表中的任意结点或者null。
     * 思路：（1）在原链表的每一个结点的下一个结点复制结点（2）将原链表与复制链表分离
     */

    public static ListNode deleteNode2(ListNode head){
        if (head == null){
            return null;
        }

        ListNode currentNode = head;

        while (currentNode != null){ //第一次遍历，复制next结点
            ListNode newhead = null;
            newhead.val = currentNode.val;
            newhead.next = currentNode.next;
            currentNode.next = newhead;
            currentNode = currentNode.next;
        }


        ListNode node = head;
        while (node != null){ //第二次遍历，复制sbiling结点
            if (node.sbiling != null){
                node.next.sbiling = node.sbiling.next;
            }
            node = node.next;
        }

        ListNode Node = head;
        ListNode copyNode = null;
        while (Node != null){
            copyNode = Node.next;
            if (Node.sbiling != null){
                copyNode.sbiling = Node.sbiling.next;
            }
            Node = copyNode.next;
        }

        return copyNode;

    }
}
