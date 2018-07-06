package com.leaning;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.plaf.PanelUI;
import java.io.*;

/**
 * Created by sqy on 2018/7/4.
 */
public class IOTest {
    String src = "G:\\test.txt";

    public void get(){ //从文件中读出数据
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src),"gbk"));
            String s ;
            while ((s=bufferedReader.readLine()) !=null){
                System.out.println(s);
            }


            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void put(){//从控制台输入数据，并写入到文件中
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = reader.readLine();
            FileWriter writer = new FileWriter(new File(src),true);
            writer.append(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        IOTest test = new IOTest();
        //test.get();
        test.put();
    }
}
