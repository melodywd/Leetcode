package com.fay.linkedList;
import java.util.Scanner;

public class Solution7ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        ListNode l1 = buildList(m, sc);
        int n = sc.nextInt();
        ListNode l2 = buildList(n, sc);
        // 打印链表
        ListNode res = addTwoNumbers(l1,l2);
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
        ListNode cur = dummy;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义两个数之和的虚拟头节点
        ListNode dummy = new ListNode(0);
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
