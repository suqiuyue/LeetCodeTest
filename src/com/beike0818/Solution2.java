package com.beike0818;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 百度2018秋招第2题：安排机器
 */
public class Solution2 {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> machineLists = new ArrayList<>();
        ArrayList<ArrayList<Integer>> taskLists = new ArrayList<>();
        machineLists.add(new ArrayList<>(Arrays.asList(100,3)));
        machineLists.add(new ArrayList<>(Arrays.asList(200,4)));
        taskLists.add(new ArrayList<>(Arrays.asList(100,1)));
        taskLists.add(new ArrayList<>(Arrays.asList(100,2)));
        taskLists.add(new ArrayList<>(Arrays.asList(150,4)));

        int m = 2;
        System.out.println(getMaxPrice(m,machineLists,taskLists));

    }

    public static ArrayList<Integer> getMaxPrice(int m,ArrayList<ArrayList<Integer>> machineLists,ArrayList<ArrayList<Integer>> taskLists){
        int machinePrice = 0,taskPrice = 0;
        int machineTime = 0,machineLevel = 0,taskTime = 0,taskLevel = 0;
        int[] maxPrice = new int[m];
        int finshTask = 0,totalPrice = 0;

        ArrayList<ArrayList<Integer>> newMachineLists = new ArrayList<>();
        ArrayList<ArrayList<Integer>> newTaskLists = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < machineLists.size(); i++) {
            ArrayList<Integer> machineList = new ArrayList<>();
            machinePrice = machineLists.get(i).get(0) * 200 + machineLists.get(i).get(1) * 3;
            machineList.add(machineLists.get(i).get(0));
            machineList.add(machineLists.get(i).get(1));
            machineList.add(machinePrice);
            newMachineLists.add(machineList);
        }
        sort(newMachineLists);

        for (int i = 0; i < taskLists.size(); i++) {
            ArrayList<Integer> taskList = new ArrayList<>();
            taskPrice = taskLists.get(i).get(0) * 200 + taskLists.get(i).get(1) * 3;
            taskList.add(taskLists.get(i).get(0));
            taskList.add(taskLists.get(i).get(1));
            taskList.add(taskPrice);
            newTaskLists.add(taskList);
        }
        sort(newTaskLists);

        for (int i = 0; i < newMachineLists.size(); i++) {

            machineTime = newMachineLists.get(i).get(0);
            machineLevel = newMachineLists.get(i).get(1);
            machinePrice = newMachineLists.get(i).get(2);
            int isUsed = 0;
            newMachineLists.get(i).add(isUsed);

            for (int j = 0; j < newTaskLists.size(); j++) {

               taskTime = newTaskLists.get(j).get(0);
               taskLevel = newTaskLists.get(j).get(1);
               taskPrice = newTaskLists.get(j).get(2);
               if (newMachineLists.get(i).get(3) == 0){
                   if (machinePrice >= taskPrice && machineLevel >= taskLevel && machineTime >= taskTime){
                       maxPrice[j] = taskPrice;
                       newMachineLists.get(i).set(3,1);
                   }
               }
            }
        }
        for (int i = 0; i < maxPrice.length; i++) {
            if (maxPrice[i] != 0){
                finshTask ++;
                totalPrice += maxPrice[i];
            }
        }
        result.add(finshTask);
        result.add(totalPrice);
        return result;
    }
    public static void sort(ArrayList<ArrayList<Integer>> lists){
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.size()-i-1; j++) {
                if (lists.get(j).get(2) < lists.get(j+1).get(2)){
                    ArrayList<Integer> tmp = lists.get(j);
                    lists.set(j,lists.get(j+1));
                    lists.set(j+1,tmp);
                }
            }
        }
    }
}
