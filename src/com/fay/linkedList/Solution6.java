package com.fay.linkedList;

public class Solution6 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        // 指针从头节点开始
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            // 节点值小的拼在前面，更新指针
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 更新合并后的链表指针
            cur = cur.next;
        }
        // 拼接剩下的链表
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
