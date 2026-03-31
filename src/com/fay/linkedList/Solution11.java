package com.fay.linkedList;


import java.util.HashMap;
import java.util.Map;

public class Solution11 {
    public Node copyRandomList(Node head) {
        // 头节点为空，返回空
        if (head == null) return null;
        // 用哈希表复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 更新复制链表节点的 next 和 random指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }
}
