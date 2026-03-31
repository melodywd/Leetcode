package com.fay.linkedList;

public class Solution10 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表节点个数
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义指针用于翻转
        ListNode pre = null;
        cur = head;
        // 定义每组翻转后的尾节点
        ListNode tail = dummy;
        // K 个一组翻转链表
        while (n >= k) {
            for (int i = 0; i < k; i++) {
                // 保存下一个节点
                ListNode temp = cur.next;
                cur.next = pre;
                // 更新指针
                pre = cur;
                cur = temp;
            }
            // 更新上一段尾节点指向当前头节点，当前尾节点指向下一段头节点
            ListNode temp = tail.next;
            tail.next.next = cur;
            tail.next = pre;
            // 更新尾节点
            tail = temp;
            // 更新剩余节点个数
            n -= k;
        }
        return dummy.next;
    }
}
