package com.fay.tree;
import java.util.ArrayList;
import java.util.List;


public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    // 中序遍历
    public void dfs(List<Integer> res, TreeNode root) {
        // 递归边界
        if (root == null) return ;
        // 遍历左子树
        dfs(res, root.left);
        // 添加根节点（添加根节点的顺序不同实现不同遍历方式）
        res.add(root.val);
        // 遍历右子树
        dfs(res, root.right);
    }
}
