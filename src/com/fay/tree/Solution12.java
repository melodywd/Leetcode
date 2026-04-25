package com.fay.tree;

import java.util.Arrays;

public class Solution12 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历数组为空时，递归结束
        if (preorder.length == 0) return null;

        // 根节点为 preorder[0]，根节点在inorder中的索引
        int rootIndex = indexOfRoot(inorder, preorder[0]);
        // 数组拷贝————左闭右开区间
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        // 递归左子树、右子树
        TreeNode left = buildTree(preLeft, inLeft);
        TreeNode right = buildTree(preRight, inRight);

        return new TreeNode(preorder[0], left, right);
    }

    private int indexOfRoot(int[] inorder, int root) {
        for (int i = 0; ; i++) {
            if (root == inorder[i]) return i;
        }
    }
}
