package com.fay.linkedList;

import java.util.Scanner;

public class Solution12ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = buildList(n, sc);
        ListNode res = sortList(head);
        printList(res);
    }
    // 构建链表
    private static ListNode buildList(int n, Scanner sc) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }
    // 打印链表
    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + " ");
            }else {
                System.out.print(head.val);
            }
            head = head.next;
        }
    }
    // 排序链表
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找中间节点
        ListNode middle = findMiddle(head);
        // 分治排序
        head = sortList(head);
        middle = sortList(middle);
        // 合并
        return merge(head, middle);
    }
    // 找中间节点并断开
    public static ListNode findMiddle(ListNode head) {
        // 快慢指针找中间节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = new ListNode(0);
        while (fast != null && fast.next != null) {
            // 记录中间节点的前一个节点，用于后续断开
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 从中间节点断开
        temp.next = null;
        return slow;
    }
    // 合并链表————双指针
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            // 按照从小到大排序
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
