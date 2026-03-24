package com.fay.linkedList;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        // 定义两个指针用于反转链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 临时指针保存下一个结点
            ListNode temp = cur.next;
            // 反转当前结点方向
            cur.next = pre;
            // 更新结点
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
