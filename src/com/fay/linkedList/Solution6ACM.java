package com.fay.linkedList;
import java.util.*;

public class Solution6ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 构建链表
        int m = sc.nextInt();
        ListNode head1 = buildList(m, sc);
        int n = sc.nextInt();
        ListNode head2 = buildList(n, sc);
        ListNode res = mergeTwoLists(head1,head2);
        // 打印链表
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + " ");
            }else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }
    // 构建链表
    private static ListNode buildList(int m, Scanner sc) {
        ListNode dummy = new ListNode(0);
        ListNode cur1 = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur1.next = new ListNode(x);
            cur1 = cur1.next;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
