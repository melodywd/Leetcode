package com.fay.linkedList;

public class Solution8 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
