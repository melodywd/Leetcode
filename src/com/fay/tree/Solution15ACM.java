package com.fay.tree;
import java.util.*;

public class Solution15ACM {

    private static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nodes = new String[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.next();
        }
        TreeNode root = buildTree(nodes);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    // 返回当前节点的最大链长
    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right + root.val, res);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
    public static TreeNode buildTree (String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode cur = queue.poll();
            if (!nodes[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            if (index < nodes.length) {
                if (!nodes[index].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(cur.right);
                }
                index++;
            }
        }
        return root;
    }
}
