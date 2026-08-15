package com.fay.tree;
import java.util.*;

public class Solution6ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        System.out.println(levelOrder(root));
    }
    // 层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    // 构建二叉树
    public static TreeNode buildTree(List<Integer> nums) {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(nums.get(0));
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
