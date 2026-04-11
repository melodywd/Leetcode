package com.fay.tree;

public class TreeNode {
    int val;
    com.fay.tree.TreeNode left;
    com.fay.tree.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, com.fay.tree.TreeNode left, com.fay.tree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
