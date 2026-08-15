package com.fay.tree;

import java.util.*;

public class Solution7ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        printTree(sortedArrayToBST(nums));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
    public static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.add(Integer.MIN_VALUE);
            } else {
                res.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        for (Integer s : res) {
            if (s != Integer.MIN_VALUE) {
                System.out.print(s + " ");
            }else {
                System.out.print(null + " ");
            }

        }
    }
}
