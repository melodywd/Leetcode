package com.fay.linkedList;

public class Solution7 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义两个数之和的虚拟头节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // 进位
        int num = 0;
        while (l1 != null || l2 != null || num != 0) {
            // 节点不为空就把值和进位加一起
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            // 新的节点存一个数位
            cur.next = new ListNode(num % 10);
            // 更新节点
            cur = cur.next;
            // 更新进位
            num /= 10;
        }
        return dummy.next;
    }
}
