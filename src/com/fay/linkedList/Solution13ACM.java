package com.fay.linkedList;
import java.util.*;

public class Solution13ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode[] list = new ListNode[k];
        // 构造链表
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int j = 0; j < n; j++) {
                cur.next = new ListNode(sc.nextInt());
                cur = cur.next;
            }
            list[i] = dummy.next;
        }
        ListNode res = mergeKLists(list);
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
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // 最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        // 将升序链表头节点加入最小堆
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        // 合并排序
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            // 取出最小节点
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            // 加入下一节点
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
