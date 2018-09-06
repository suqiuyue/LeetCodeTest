package com.xiecheng0904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @data 2018/9/4 19:38
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("记录数：");
        long recode = sc.nextLong();
        System.out.println("时间值A：");
        long time = sc.nextLong();
        System.out.println("订单号"+" "+"入店时间"+" "+"离店时间");
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i <= recode ; i++) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            list.add(strings);
        }

        String I = Long.toString(time);
        isContain(I,list);

    }

    public static void isContain(String targetDataString,ArrayList<String[]> dataMargin){
        for (int i = 1; i < dataMargin.size(); i++) {
            String Data[] = dataMargin.get(i);
            String startData = Data[1];
            String endData = Data[2];
            if (getDay(targetDataString)>getDay(startData)&&getDay(targetDataString)<getDay(endData)) {
                System.out.println(Data[0]);
            }else {
                System.out.println("null");
            }
        }

    }

    public static int getDay (String data){
        String year = data.substring(0, 4);
        int yearI = Integer.parseInt(year);


        String mon = data.substring(5, 6);
        int moni = Integer.parseInt(mon);

        String day = data.substring(7, 8);
        int dayi = Integer.parseInt(day);
        return getDay_switchCase(yearI,moni,dayi);
    }
    public static int getDay_switchCase(int year,int month,int day){
        //1、定义相关的变量
        int sumDays=0;//对应的总天数

        //2、判断是否为闰年并且月份大于2   若是总天数多一天
        if((year%4==0&&year%100!=0||year%400==0)&&month>2){
            sumDays=1;//将闰年的二月份多出的一天加上
        }

        //3、加上之前几个月的天数
        for(int i=1;i<month;i++){
            switch(i){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
//          case 12:
                    sumDays+=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sumDays+=30;
                    break;
                case 2:sumDays+=28;
            }
        }

        //4、加上当月对应的天数
        sumDays+=day;
        return  sumDays + year*365;
    }


}
