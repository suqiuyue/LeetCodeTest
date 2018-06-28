package com.company;

import java.util.*;

/**
 * Created by sqy on 2018/3/13.
 */
public class ReverseInteger {
    public static void main(String[] args){
        /*int a= 0x12345678;
        System.out.println(Integer.toBinaryString(a));
        int r =Integer.reverse(a);
        System.out.println(Integer.toBinaryString(r));
        int c= Integer.reverseBytes(a);
        System.out.println(Integer.toHexString(c));*/
       /* int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
                {8,10,14,17}
        };
        System.out.println(find(1,arr));//true

        StringBuffer str =new StringBuffer("we are happy");
        System.out.println(replaceSpace(str));*/


        ReverseInteger re = new ReverseInteger();
       // System.out.println(re.printListFromTailToHead(listNode));

    }

    public static boolean find(int target,int[][] array){

        int rows = array.length;
        int colums = array[0].length;
        boolean flag = false;
        if(array!=null && rows>0 &&colums>0)
        {
          int row = 0;
          int col = colums -1;
          while (row<rows && col>=0)
          {
              if(array[row][col]<target)
              {
                  row++;
              }else if(array[row][col]>target)
              {
                  col--;
              }else
                  {
                      flag = true;
                      break;
                  }
          }
        }
        return flag;
    }

    public static String replaceSpace(StringBuffer str){
        StringBuffer newstr = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char a = str.charAt(i);
            if(a ==' '){
               newstr.append("%20");
            }else {
                newstr.append(a);
            }
        }
        return newstr.toString();
    }

    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode){

       ArrayList<Integer> list = new ArrayList<Integer>();
       if(listNode !=null) {
           if (listNode.next != null) {
               list = printListFromTailToHead(listNode.next);
           }
       }
       if(listNode !=null){
           list.add(listNode.val);
       }
       return list;

    }

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
