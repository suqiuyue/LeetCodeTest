package com.huawei0815;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @data 2018/8/15 19:36
 */
public class Main {
    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> lists = single();
        getGroup(lists);
    }
    public static ArrayList<ArrayList<Integer>> single(){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 12; i <= 20; i++) {
            for (int j = 12; j <= 20; j++) {
                Random rm =new Random();

            }
        }
        boolean flag = true;
        while (flag) {
            String str = sc.nextLine();
            String[] numstr = str.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            if (numstr.length == 2) {
                int x = Integer.parseInt(numstr[0]);
                int y = Integer.parseInt(numstr[1]);
                if (x == -1 && y == -1){
                        flag = false;
                        break;
                }
                if (x >= 12 && x <= 20 && y >=12 && y <=20 && x < y) {
                    list.add(x);
                    list.add(y);
                }
                if (list == null || list.size() == 0){
                    continue;
                }
                lists.add(list);
                if (lists.size() > 100){
                    lists.remove(lists.size()-1);
                    break;
                }
            }
        }
        return lists;
    }

    public static void getGroup( ArrayList<ArrayList<Integer>> lists){

        ArrayList<ArrayList<Integer>> listEnd = new ArrayList();
        ArrayList<Integer> listParse ;
        for (int listNum = 0; listNum < lists.size(); listNum++) {
            ArrayList<Integer> listComtainNum = new ArrayList();
            listParse =  lists.get(listNum);

            for (int num = listParse.get(0); num <= listParse.get(1); num++) {
                listComtainNum.add(num);
            }
            listEnd.add(listComtainNum);
        }
        for (int time = 12; time < 20 ; time++) {
            //计算每个小时
            int num = 0;
            for (int intach = 0; intach < listEnd.size(); intach++) {
                //计算每个组是否有人
                ArrayList<Integer> eachList = listEnd.get(intach);
                num = num + getIsStay(time,eachList);
            }
            if(num > 100){
                num = 100;
            }
            System.out.println("["+time+","+(time+1)+"):"+num);
        }

    }
    public static Integer getIsStay(int time,ArrayList<Integer> eachlist){

        if (eachlist.contains(time) && eachlist.contains(time+1)) {
            return 1;
        }
        return 0;
    }

}
