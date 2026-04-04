package com.fay.linkedList;

public class Solution12 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找中间节点
        ListNode midNode = findMin(head);
        // 分治
        head = sortList(head);
        midNode = sortList(midNode);
        // 合并链表
        return merge(head,midNode);
    }
    // 找中间节点
    public static ListNode findMin(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = new ListNode(0);
        while (fast != null && fast.next != null) {
            // 记录中间节点的前一个节点
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将节点从中间断开
        temp.next = null;
        return slow;
    }
    // 合并链表————双指针
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
