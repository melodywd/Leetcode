package com.fay.tree;

import java.util.*;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        invertTree(root);
        printTree(root);
    }
    // 翻转二叉树
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
    // 构建二叉树
    public static TreeNode buildTree(List<Integer> nums) {
        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nums.size()) {
            TreeNode cur =  queue.poll();
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
    // 打印二叉树
    public static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
