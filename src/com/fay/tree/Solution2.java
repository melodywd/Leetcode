package com.fay.tree;

import com.fay.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int maxDepth1(TreeNode root) {
        // 递归边界，到空节点深度为0
        if (root == null) return 0;
        // 根节点的深度 = 左子树和右子树深度的最大值 + 1；
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        // 根节点加入队列
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            // 临时链表存入下一层节点
            List<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
