package com.fay.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;

        // 首次到达该层
        if (depth == res.size()) {
            res.add(root.val);
        }
        // 递归右子树
        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }
}
