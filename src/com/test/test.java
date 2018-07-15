package com.test;

import java.io.*;

/**
 * Created by sqy on 2018/7/3.
 */
public class test {

    static String src ="";

    public static void main(StringTest[] args){

           /*System.out.println("请输入一个整数：");
           int a = test.getInt();
           getResult(a);*/

          Cat cat =  new Cat();
         // cat.getfly();
          Animal animal = cat;
          animal.getfly();
          /*Animal animal = new Cat();
          animal.getfly();*/




    }

    public static void fileOperation(String src){

        //将数据写入文件
        try {
            FileOutputStream out = new FileOutputStream(src);//从内存中输出到文件中
            out.write("字符串写入文件".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从文件中读数据
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));

            System.out.println(reader.readLine().trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getResult(int x){

        System.out.println(x+"的平方="+x*x);
        System.out.println(x+"的立方="+x*x*x);

    }

    public static void input(){
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        try {
            src = bu.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getInt(){
        input();
        return Integer.parseInt(src);
    }

}
