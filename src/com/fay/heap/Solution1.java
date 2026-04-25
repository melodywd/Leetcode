package com.fay.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }
    public int quickSelect(List<Integer> nums, int k) {
        // 随机基准元素
        Random r = new Random();
        int pivot = nums.get(r.nextInt(nums.size()));

        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        // 遍历集合，大的放右边，小的放左边
        for (Integer num : nums) {
            if (num < pivot) {
                small.add(num);
            }else if (num > pivot) {
                big.add(num);
            }else {
                equal.add(num);
            }
        }
        // 第 K 大元素在 big 中，递归
        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        // 第 K 大元素在 small 中，递归
        if (nums.size() - small.size() < k) {
            return quickSelect(small, k - nums.size() + small.size());
        }
        // 第 K 大元素是基准元素
        return pivot;
    }
}
