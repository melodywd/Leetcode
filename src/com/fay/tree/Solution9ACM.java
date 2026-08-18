package com.fay.tree;
import java.util.*;

public class Solution9ACM {

    private static int k;
    private static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        if (nums.isEmpty() || nums.get(0) == -1) return;
        TreeNode root = buildTree(nums);
        System.out.println(kthSmallest(root,k));
    }
    // 寻找二叉搜索树第K小的元素
    public static int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return res;
    }
    // 中序遍历二叉搜索树，第K个节点为第K小的元素
    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        dfs(root.right);
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
