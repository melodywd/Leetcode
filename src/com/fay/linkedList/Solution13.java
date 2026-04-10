package com.fay.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution13 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // 最小堆，根节点为最小值
        PriorityQueue<ListNode> pq = new PriorityQueue<>(( a,  b) -> a.val - b.val);
        // 遍历链表集合，将各链表的头节点加入堆
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 遍历堆中节点
        while (!pq.isEmpty()) {
            // 取出最小节点
            ListNode node = pq.poll();
            // 更新指针
            cur.next = node;
            cur = cur.next;
            // 下一个节点可能是最小节点，入堆
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
