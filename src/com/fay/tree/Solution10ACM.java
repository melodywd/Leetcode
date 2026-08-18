package com.fay.tree;

import java.util.*;

public class Solution10ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        System.out.println(rightSideView1(root));
        System.out.println(rightSideView2(root));
    }
    // DFS 递归遍历
    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    // BFS 层序遍历
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            res.add(cur.get(cur.size()-1).val);
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            cur = temp;
        }
        return res;
    }
    public static void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);
        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }
    public static TreeNode buildTree(List<Integer> nums) {
        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nums.size()) {
            TreeNode cur = queue.poll();
            if (index < nums.size()) {
                if (nums.get(index) != -1) {
                    cur.left = new TreeNode(nums.get(index));
                    queue.offer(cur.left);
                }
                index++;
            }
            if (index < nums.size()) {
                if (nums.get(index) != -1) {
                    cur.right = new TreeNode(nums.get(index));
                    queue.offer(cur.right);
                }
                index++;
            }
        }
        return root;
    }
}
