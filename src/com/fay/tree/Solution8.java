package com.fay.tree;

public class Solution8 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root,long min, long max) {
        if (root == null) return true;
        // 不满足在最值范围内返回 false
        if (root.val <= min || root.val >= max) return false;
        // 更新最值为根节点值，判断左子树和右子树
        return dfs(root.left, min, root.val)
                && dfs(root.right, root.val, max);
    }
}
