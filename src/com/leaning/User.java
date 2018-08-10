package com.leaning;

import java.io.*;

/**
 * Created by sqy on 2018/8/8.
 */
public class User implements Serializable {
    private String name;
    private String gender;
    private int id;

    public User(String name,String gender,int id){
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args){
        User user = new User("suqiuyue","women",2);

        try {
            //序列化
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\serialiableTest.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(user);

            fileOutputStream.close();
            objectOutputStream.close();

            //反序列化
            FileInputStream fis = new FileInputStream("F:\\serialiableTest.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user2 = (User) ois.readObject();
            System.out.println(user2.getName()+ " " +
                    user2.getGender() + " " + user2.getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
