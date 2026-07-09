package com.fay.linkedList;
import java.util.*;

public class Solution11ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        int[] randomIndex = new int[n];

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int index = sc.nextInt();
            nodes[i] = new Node(val);
            randomIndex[i] = index;
        }
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i+1];
        }
        for (int i = 0; i < n; i++) {
            if (randomIndex[i] != -1) {
                nodes[i].random = nodes[randomIndex[i]];
            }
        }
        Node res = copyRandomList(nodes[0]);
        Map<Node, Integer> indexMap = new HashMap<>();
        int index = 0;
        Node cur = res;
        // 哈希表存随机节点的索引，用于打印
        while (cur != null) {
            indexMap.put(cur, index++);
            cur = cur.next;
        }
        cur = res;
        // 打印结果链表
        while (cur!= null) {
            int resIndex = cur.random == null ? -1 : indexMap.get(cur.random);
            System.out.println(cur.val + " " + resIndex);
            cur = cur.next;
        }
    }
    public static Node copyRandomList(Node head) {
        // 头节点为空，返回空
        if (head == null) return null;
        // 用哈希表复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
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
