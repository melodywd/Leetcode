package com.fay.linkedList;
import java.util.Scanner;

public class Solution9ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        ListNode head = buildList(m, sc);
        ListNode res = swapPairs(head);
        printList(res);
    }
    // 构建链表
    private static ListNode buildList(int m, Scanner sc) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }
    // 打印链表
    private static void printList(ListNode res) {
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + " ");
            }else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }
    // 两两交换节点
    public static ListNode swapPairs(ListNode head) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
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
