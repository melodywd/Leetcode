package com.fay.tree;

import java.util.*;

public class Solution11ACM {

    // 全局变量存储上一节点
    private static TreeNode temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        flatten(root);
        printTree(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = temp;
        temp = root;
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

    public static void printTree(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
