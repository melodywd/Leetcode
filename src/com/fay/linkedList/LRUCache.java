package com.fay.linkedList;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // 定义双向链表节点
    private static class Node {
        int key;
        int value;
        Node prev,next;

        Node (int k, int v) {
            key = k;
            value = v;
        }
    }
    // 容量、虚拟头节点、哈希表（存节点）
    private final int capacity;
    private final Node dummy = new Node(0,0);
    private final Map<Integer, Node> NodeMap = new HashMap<>();

    // 构造函数初始化
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }
    // 获取节点
    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }
    // 添加节点
    public void put(int key, int value) {
        // 节点存在
        if (NodeMap.containsKey(key)) {
            // 将节点移到头节点
            Node node = getNode(key);
            // 更新 value
            node.value = value;
        }else {
            // 不存在则添加一个新节点，并放在头节点位置
            Node node = new Node(key, value);
            // 加入哈希表
            NodeMap.put(key, node);
            addToHead(node);
        }
        // 超过容量，删除最后操作的节点即尾节点
        if (NodeMap.size() > capacity) {
            Node tail = dummy.prev;
            NodeMap.remove(tail.key);
            remove(tail);
        }
    }
    // 获取节点，并将节点移到头节点位置
    public Node getNode(int key) {
        if (!NodeMap.containsKey(key)) {
            return null;
        }
        Node node = NodeMap.get(key);
        // 移除节点
        remove(node);
        // 将节点放在头节点
        addToHead(node);
        return node;
    }
    // 移除节点
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 节点移到头节点位置
    public void addToHead(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }
}

