package com.fay.tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution1 {
    // 递归实现遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
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
    // 非递归遍历————迭代遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 栈来模拟实现递归调用
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        // 树没有遍历完或者栈没空
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                // 将左子树的左子节点依次入栈
                st.push(cur);
                cur = cur.left;
            }
            // 弹出栈顶节点
            cur = st.pop();
            // 访问当前节点，加入集合
            res.add(cur.val);
            // 访问右子树
            cur = cur.right;
        }
        return res;
    }
}
