package com.fay.doubleptr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // 先排序数组
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素大于0，后面元素不可能和当前元素组成和为零的数组，结束循环
            if (nums[i] > 0){
                break;
            }
            // 去重：如果当前元素与前一个元素相同，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if (nums[i] + nums[j] + nums[k] < 0){
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }else {
                    // 定义集合存放和为零的三个元素
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    resList.add(list);
                    j++;
                    k--;
                    // 去重：跳过重复的元素
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return resList;
    }
}
