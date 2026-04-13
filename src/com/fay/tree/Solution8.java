package com.fay.tree;

public class Solution8 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return  root.val > root.left.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right);
    }
}
