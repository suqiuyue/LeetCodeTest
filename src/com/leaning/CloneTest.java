package com.leaning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sqy on 2018/7/5.
 */
public class CloneTest implements Cloneable{

    private String name;
    private int age;
    private List<String> book;



    public CloneTest clone(){
        CloneTest obj = null;
        try {
            obj = (CloneTest)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return obj;
    }


    public static void main(String[] args){
        CloneTest cloneTest = new CloneTest();
        cloneTest.setAge(23);
        cloneTest.setName("zhangShan");
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        cloneTest.setBook(list);

        System.out.println("原始对象信息："+cloneTest.toString());

        CloneTest clone = cloneTest.clone();

        cloneTest.setAge(28);
        cloneTest.setName("lisi");
        cloneTest.getBook().add("c");
        System.out.println("原始对象信息："+cloneTest.toString()+"克隆对象信息："+clone.toString());

        cloneTest.setBook(Arrays.asList("go"));
        System.out.println("原始对象信息："+cloneTest.toString()+"克隆对象信息："+clone.toString());

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getBook() {
        return book;
    }

    public void setBook(List<String> book) {
        this.book = book;
    }

}
