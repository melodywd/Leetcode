package com.fay.tree;

public class Solution4 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    // 判断左右子节点是否为镜像
    public boolean isSame(TreeNode left, TreeNode right) {
        // 都为空是镜像
        if (left == null && right == null) return true;
        // 只有一个为空不是镜像
        if (left == null || right == null) return false;
        // 镜像满足条件：节点值相等、左左和右右、左右和右左都为镜像
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
