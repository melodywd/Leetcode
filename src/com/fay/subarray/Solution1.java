package com.fay.subarray;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        // 定义结果集和前缀和
        int sum = 0;
        int res = 0;
        // 哈希表用来存前缀和和出现次数
        Map<Integer,Integer> map = new HashMap<>();
        // 添加前缀和为0的元素
        map.put(0,1);
        // 遍历数组求前缀和并判断哈希表中是否有满足条件的前缀和
        for (int num : nums) {
            sum += num;
            // 满足条件则结果集加1
            res += map.getOrDefault(sum - k, 0);
            // 添加前缀和
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
