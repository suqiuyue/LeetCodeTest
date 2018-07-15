package com.test;

/**
 * Created by sqy on 2018/7/10.
 */
public class StringTest {

    public static void main(String[] args){
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello" + "word";
        String s4 = "helloword";
        String s5 = "hello"+2;
        String s6 = "hello2";

        boolean flag1 = s1.equals(s2);
        boolean flag2 = s3.equals(s4);

        System.out.println("flag1:"+flag1+" ,"+"flag2:"+flag2);

        if (s1 == s2){
            System.out.println("s1 == s2 ==> true");
        }else {
            System.out.println("s1 == s2 ==> false");
        }

        if (s3 == s4){
            System.out.println("s3 == s4 ==> true");
        }else {
            System.out.println("s3 == s4 ==> false");
        }

        if (s5 ==s6){
            System.out.println("s5 == s6 ==> true");
        }else {
            System.out.println("s5 == s6 ==> false");
        }

        String a = "hello";
        String b =  new String("hello");
        String c =  new String("hello");
        String d = b.intern();

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(b==d);
        System.out.println(a==d);
    }
}
