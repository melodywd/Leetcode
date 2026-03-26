package com.fay.linkedList;

public class Solution9 {
    public ListNode swapPairs(ListNode head) {
        // 虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        // 后面两个节点不为空再交换
        while (cur.next != null && cur.next.next != null) {
            // 两个指针用于交换
            ListNode l1 = cur.next;
            ListNode l2 = l1.next;
            // 临时保存第三个节点
            ListNode l3 = l2.next;
            cur.next = l2;
            l2.next = l1;
            l1.next = l3;
            // 更新指针
            cur = l1;
        }
        return dummy.next;
    }
}
