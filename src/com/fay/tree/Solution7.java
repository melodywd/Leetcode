package com.fay.tree;

public class Solution7 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        // 中间节点为根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 左右区间为左右子树
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
