package com.fay.tree;
import java.util.*;

public class Solution12ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        TreeNode root = buildTree(preorder,inorder);
        printTree(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int rootIndex = indexOfRoot(inorder,preorder[0]);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        TreeNode left = buildTree(preLeft,inLeft);
        TreeNode right = buildTree(preRight,inRight);
        return new TreeNode(preorder[0], left, right);
    }

    private static int indexOfRoot(int[] inorder, int root) {
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) return i;
        }
        return -1;
    }
    public static void printTree(TreeNode root) {
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
