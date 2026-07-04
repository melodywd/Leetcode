package com.fay.linkedList;

import java.util.Scanner;

public class Solution5ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        // 环的入口索引
        int pos = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        // 构造环
        if (pos != -1) {
            ListNode first = dummy;
            for (int i = 0; i <= pos; i++) {
                first = first.next;
            }
            cur.next = first;
        }
        ListNode res = detectCycle(dummy.next);
        if (res == null) {
            System.out.println("null");
        }else {
            System.out.println(res.val);
        }
    }
    public static ListNode detectCycle(ListNode head) {
        // 双指针
        ListNode slow = head;
        ListNode fast = head;
        // 快指针先进入环，慢指针后进入
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 相遇时，说明有环，快指针从头节点出发
            if (slow == fast) {
                fast = head;
                // 下次相遇就是环的入口
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
