package com.fay.linkedList;
import java.util.*;

public class Solution1ACM {
    public static void main(String[] args) {
        // 输入示例：
        // 8
        // 5
        // 4 1 8 4 5
        // 6
        // 5 6 1 8 4 5
        // 2 3
        // 输出示例：
        // 8
        Scanner sc = new Scanner(System.in);
        // 交点
        int  intersection = sc.nextInt();
        // 构建 A 链表
        int m = sc.nextInt();
        ListNode headA = null;
        ListNode tailA = null;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            ListNode node = new ListNode(x);
            if (headA == null) {
                headA = tailA = node;
            }
            tailA.next = node;
            tailA = tailA.next;
        }
        // 构建 B 链表
        int n = sc.nextInt();
        ListNode headB = null;
        ListNode tailB = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            ListNode node = new ListNode(x);
            if (headB == null) {
                headB = tailB = node;
            }
            tailB.next = node;
            tailB = tailB.next;
        }
        if (headA != null && headB != null) return;
        // 构建 B 相交前部分
        int skipA = sc.nextInt();
        int skipB = sc.nextInt();
        ListNode curA = headA;
        ListNode curB = headB;
        for (int i = 1; i < skipA; i++) {
            curA = curA.next;
        }
        for (int i = 1; i < skipB; i++) {
            curB = curB.next;
        }
        // 有相交点
        if (intersection != 0) {
            curB.next = curA.next;
        }
        ListNode resultNode = getIntersectionNode(headA,headB);
        if (resultNode == null) {
            System.out.println("无交点");
        }else {
            System.out.println(resultNode.val);
        }
    }
    // 找到相交链表交点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 定义两个指针，分别从A、B两个结点遍历
        ListNode skipA = headA;
        ListNode skipB = headB;
        while (skipA != skipB) {
            // 遍历完接着遍历另一个节点，直到走到相交结点或者末尾
            skipA = skipA == null ? headB : skipA.next;
            skipB = skipB == null ? headA : skipB.next;
        }
        return skipA;
    }
}
