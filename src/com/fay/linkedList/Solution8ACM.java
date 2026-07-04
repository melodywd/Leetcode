package com.fay.linkedList;

import java.util.Scanner;

public class Solution8ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ListNode head = buildList(m, sc);
        ListNode res = removeNthFromEnd(head, n);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + " ");
            }else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }
    // 构建链表
    private static ListNode buildList(int m, Scanner sc) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义两个指针
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 两个指针同时走，直到快指针走到最后一个节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 慢指针在倒数第n+1个节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
