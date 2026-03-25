package com.fay.linkedList;

public class Solution3 {
    public boolean isPalindrome(ListNode head) {
        // 找到中间节点
        ListNode middle = findMiddle(head);
        // 反转后半部分链表
        ListNode head2 = reverse(middle);
        // 双指针分别从两端遍历，判断head2 是否为空
        while (head2 != null) {
            // 值不相等不是回文链表
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    // 定义找中间节点的方法
    private ListNode findMiddle(ListNode head) {
        // 快慢指针，快指针走两步，慢指针一步
        ListNode slow = head;
        ListNode fast = head;
        // 快指针到末尾，慢指针到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 反转链表的方法
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
