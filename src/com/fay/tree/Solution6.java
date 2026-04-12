package com.fay.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution6 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 队列实现层序遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // 临时集合存入当前层节点的值
            List<Integer> temp = new ArrayList<>();
            // 记录当前层节点个数
            int n =  q.size();
            // 遍历当前层的节点
            for (int i = 0; i < n; i++) {
                // 取出队头节点
                TreeNode node = q.poll();
                temp.add(node.val);
                // 将下一层节点加入队列
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // 当前层加入结果集合
            res.add(temp);
        }
        return res;
    }
}
