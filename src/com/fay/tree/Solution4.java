package com.fay.tree;

public class Solution4 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    // 判断左右子节点是否为镜像
    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        // 左子节点的左子树和右节点的右子树、左节点的
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
