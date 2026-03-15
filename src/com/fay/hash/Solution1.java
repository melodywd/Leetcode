package com.fay.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }
    public static int[] twoSum(int[] nums, int target){
        // 哈希表，key为数组元素，value为数组元素的索引
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // key 唯一性
            if (hm.containsKey(target - nums[i])){
                return new int[]{hm.get(target - nums[i]),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}
