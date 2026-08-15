package com.fay.tree;
import java.util.*;

public class Solution5ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int res = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    public static int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        res = Math.max(res, left + right);
        return Math.max(left, right);
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
