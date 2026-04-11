package com.fay.tree;

public class Solution3 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        // 翻转左子树和右子树
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
