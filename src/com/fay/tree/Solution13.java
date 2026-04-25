package com.fay.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    private int res;
    public int pathSum(TreeNode root, int targetSum) {
        // 哈希表
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, 0L, targetSum, map);
        return res;
    }
    // s 表示从根到 node 的父节点的节点值之和（node 的节点值尚未计入）
    public void dfs(TreeNode root, Long s, int targetSum, Map<Long, Integer> map) {
        if (root == null) return;

        s += root.val;
        res += map.getOrDefault(s - targetSum, 0);
        // 将节点值和加入哈希表
        map.put(s, map.getOrDefault(s, 0) + 1);
        // 递归左右子树
        dfs(root.left, s, targetSum, map);
        dfs(root.right, s, targetSum, map);
        // 回溯撤销，回到父节点，在哈希表中去掉节点值和
        map.put(s, map.getOrDefault(s, 0) - 1);
    }
}
