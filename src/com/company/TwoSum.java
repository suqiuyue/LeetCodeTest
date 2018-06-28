package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sqy on 2018/3/9.
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        int[] c = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[i]+nums[j] == target){
                    c[0]=i;
                    c[1]=j;
                }
            }
        }
        return c;
    }

    public int[] hashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {

                System.out.println(new int[] { i, map.get(complement) });
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] hashmap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) { //边做判断边将数组中的元素存入hashmap中
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(new int[] { i, map.get(complement) });
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
