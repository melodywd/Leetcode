package com.fay.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1ACM {

    public static int[] twoSum(int[] nums, int target){
        // 哈希表，key为数组元素，value为数组元素的索引
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{i,hm.get(target - nums[i])};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = twoSum(nums,target);
        System.out.println(result[0] + " " + result[1]);
    }
}
