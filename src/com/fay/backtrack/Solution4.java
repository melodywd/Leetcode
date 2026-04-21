package com.fay.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 排序数组
        Arrays.sort(candidates);
        dfs(0, candidates, target, ans, path);
        return ans;
    }
    public static void dfs(int start, int[] candidates, int target, List<List<Integer>> ans, List<Integer> path) {
        // 递归边界
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < candidates.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - candidates[start] < 0) {
                break;
            }
            // 尝试选择
            path.add(candidates[i]);
            // 进行下一轮选择，可重复选，所以从 i 开始
            dfs(i, candidates, target - candidates[i],ans,path);
            // 回退
            path.remove(path.size() - 1);
        }
    }
}
