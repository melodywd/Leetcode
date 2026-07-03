package com.fay.linkedList;

import java.util.Scanner;

public class Solution2ACM {
    public static void main(String[] args) {
        // 构建链表
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        // 翻转链表
        ListNode result = reverseList(dummy.next);
        // 打印链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
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
