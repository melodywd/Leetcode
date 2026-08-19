package com.fay.tree;
import java.util.*;

public class Solution13ACM {
    public static class TreeNode {
        Long val;
        TreeNode left;
        TreeNode right;
        TreeNode (Long val) {
            this.val = val;
        }
    }
    public static int res = 0;
    public static int targetSum;
    public static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        targetSum = scanner.nextInt();
        int n = scanner.nextInt();
        String[] nodes = new String[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.next();
        }
        TreeNode root = buildTree(nodes);
        map.put(0L, 1);
        System.out.println(pathSum(root, targetSum));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        dfs(root, 0L);
        return res;
    }
    // 计算根节点到当前节点的路径和（前缀和）
    public static void dfs(TreeNode root, Long s) {
        if (root == null) return;
        s += root.val;
        res += map.getOrDefault(s - targetSum, 0);
        map.put(s, map.getOrDefault(s, 0) + 1);
        dfs(root.left, s);
        dfs(root.right, s);
        map.put(s, map.get(s) - 1);
    }
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Long.parseLong(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode cur = queue.poll();
            if (!nodes[index].equals("null")) {
                cur.left = new TreeNode(Long.parseLong(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            if (index < nodes.length) {
                if (!nodes[index].equals("null")) {
                    cur.right = new TreeNode(Long.parseLong(nodes[index]));
                    queue.offer(cur.right);
                }
                index++;
            }
        }
        return root;
    }
}
