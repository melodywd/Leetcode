package com.fay.tree;

public class Solution9 {
    private int k;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    // 中序遍历二叉搜索树，第K个节点为第K小的元素
    public void dfs(TreeNode root) {
        if (root == null || k <= 0) return;
        // 左子树
        dfs(root.left);
        k--;
        if (k == 0) {
            res = root.val;
        }
        // 右子树
        dfs(root.right);
    }
}
