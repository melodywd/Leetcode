package com.fay.tree;
import java.util.*;

public class Solution14ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();
        int n = sc.nextInt();
        String[] nodes = new String[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.next();
        }
        TreeNode root = buildTree(nodes);
        TreeNode p = findNode(root,pVal);
        TreeNode q = findNode(root,qVal);
        TreeNode res = lowestCommonAncestor(root, p, q);
        if (res != null) {
            System.out.println(res.val);
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
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
    public static TreeNode findNode (TreeNode root, int val) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == val) {
                return cur;
            }
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return null;
    }
}
