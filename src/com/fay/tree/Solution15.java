package com.fay.tree;

public class Solution15 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    // 返回当前节点的最大链长
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // 左子树最大链和
        int left = dfs(root.left);
        // 右子树最大链和
        int right = dfs(root.right);
        // 两条链拼成路径
        res = Math.max(left + right + root.val, res);
        // 返回的是链长，小于0则舍去
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
