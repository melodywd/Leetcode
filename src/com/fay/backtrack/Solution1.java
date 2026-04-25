package com.fay.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        // 所有排列的长度都是一样的 n
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] onPath = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, nums, ans, path, onPath);
        return ans;
    }

    // 枚举 path[i] 填 nums 的哪个数
    private static void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            // nums[j]没被选
            if (!onPath[j]) {
                // i的位置填入nums[j]
                path.set(i, nums[j]);
                // 标记已选上
                onPath[j] = true;
                // 填下一位
                dfs(i + 1, nums, ans, path, onPath);
                // 填完一个排列状态恢复，用于下一个排列
                onPath[j] = false;
                // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
            }
        }
    }
}
