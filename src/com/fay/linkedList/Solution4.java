package com.fay.linkedList;

public class Solution4 {
    public boolean hasCycle(ListNode head) {
        // 双指针判断是否相遇
        ListNode slow = head;
        ListNode fast = head;
        // 快指针先进入环，慢指针后进入
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
