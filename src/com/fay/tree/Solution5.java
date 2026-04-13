package com.fay.tree;

public class Solution5 {
    public int diameterOfBinaryTree(TreeNode root) {
        len(root);
        return res;
    }
    // 存储最大直径
    int res = 0;
    // 计算节点的链长————节点到叶子节点最多有多少条边
    public int len(TreeNode root) {
        // 空节点为-1，叶子节点为0
        if (root == null) return -1;
        // 子节点链长+1 = 单边链长
        int l = len(root.left) + 1;
        int r = len(root.right) + 1;
        // 更新最大直径
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
