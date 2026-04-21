package com.fay.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, ans, path);
        return ans;
    }
    public static void dfs(int start, int[] nums, List<List<Integer>> ans, List<Integer> path) {
        // 当前就是一个子集
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 加入nums[i]
            path.add(nums[i]);
            // 从 i+1 位置往后选择，不会重复
            dfs(i + 1, nums, ans, path);
            // 撤销选择，回退上一层
            path.remove(path.size() - 1);
        }
    }
}
