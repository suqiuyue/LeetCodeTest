package com.leaning;

import java.util.*;

/**
 * Created by sqy on 2018/4/25.
 */
public class Solution {
    
    public static void main(String[] args){
        int numbers[] ={2,3,1,0,2,5,3};
        int[] dulication = new int[numbers.length];
        
        Solution solution = new Solution();
        solution.duplicate(numbers,numbers.length,dulication);

    }
    
    public boolean duplicate(int numbers[],int length,int[] duplication){
        
        boolean flag = false;
        if(numbers ==null || length ==0){
            return flag;
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            int tmp = numbers[i];
            if(map.containsValue(numbers[i])){
                flag = true;
                duplication[0] = numbers[i];
                System.out.println(duplication[0]);
                break;
            }
            map.put(i,numbers[i]);

        }

        return flag;
    }

    public int JumpFloorII(int target) {

        int JumpFloor;
        if(target == 1){
            JumpFloor = 1;
        } else if(target == 2){
            JumpFloor = 2;
        } else{
            JumpFloor = 2*JumpFloorII(target-1);
        }
        return JumpFloor;
    }


}
