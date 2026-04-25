package com.fay.tree;

public class Solution14 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归边界————找到p或q就返回
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树都能找到
        if (left != null && right != null) return root;
        // 左右子树只有一个能找到或者左右子树都找不到
        return left != null ? left : right;
    }
}
