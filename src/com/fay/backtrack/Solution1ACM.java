package com.fay.backtrack;
import java.util.*;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(nums, res, path, used);
        return res;
    }
    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
               path.add(nums[i]);
               used[i] = true;
               dfs(nums, res, path, used);
               used[i] = false;
               path.remove(path.size() - 1);
            }
        }
    }
}
