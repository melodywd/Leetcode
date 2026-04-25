package com.fay.tree;

public class Solution11 {

    // 全局变量存储上一节点
    private TreeNode temp;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // 后序遍历
        flatten(root.right);
        flatten(root.left);
        // 左子树为空
        root.left = null;
        // 右子树为上一节点
        root.right = temp;
        temp = root;
    }
}
