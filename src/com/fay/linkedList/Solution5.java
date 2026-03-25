package com.fay.linkedList;

public class Solution5 {
    public ListNode detectCycle(ListNode head) {
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
