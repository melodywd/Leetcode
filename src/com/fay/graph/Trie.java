package com.fay.graph;

public class Trie {

    // 26叉树
    static class Node{
        Node[] son = new Node[26];
        boolean end = false;
    }
    private final Node root = new Node();

    // 空参构造
    public Trie() {}

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            // 顺着子结点走
            if (cur.son[c] == null) {
                // 没有路就创建
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        // 末尾节点标记为 true
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            // 没有这条路
            if (cur.son[c] == null) {
                return 0;
            }
            cur = cur.son[c];
        }
        // 走过同样的路
        // 2=完全匹配，1=前缀匹配，后面还有路
        return cur.end ? 2 : 1;
    }

}
