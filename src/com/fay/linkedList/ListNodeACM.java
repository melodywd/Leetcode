package com.fay.linkedList;

import java.util.Scanner;

public class ListNodeACM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 构建链表
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            ListNode node = new ListNode(x);
            if (head == null) {
                head = tail = node;
            }
            tail.next = node;
            tail = tail.next;
        }
        // 打印链表
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }
}
