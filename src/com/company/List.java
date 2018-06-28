package com.company;

import java.util.LinkedList;

/**
 * Created by sqy on 2018/3/30.
 */
public class List {

   public static String name ="Jack";
   String str = new String("good");
   char[] ch = {'a','b'};

   public static void change(List l){
       l.name = "Rose";
   }

   public void change1(String str,char[] ch){
       str = "test";
       ch[0] = 'h';
   }

   public static void main(String[] args){
       List a = new List();
       System.out.println(a.name);
       change(a);
       System.out.println(a.name);

       a.change1(a.str,a.ch);
       System.out.print(a.str + " and ");
       System.out.print(a.ch);
   }

}
