package com.fay.graph;

import java.util.Scanner;

public class TrieACM {

    static class Node{
        Node[] son = new Node[26];
        boolean end = false;
    }
    private final Node root = new Node();

    public TrieACM() {}

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int x = c - 'a';
            if (cur.son[x] == null) {
                cur.son[x] = new Node();
            }
            cur = cur.son[x];
        }
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
            int x = c - 'a';
            if (cur.son[x] == null) return 0;
            cur = cur.son[x];
        }
        return cur.end ? 2 : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TrieACM trie = new TrieACM();
        for (int i = 0; i < n; i++) {
            String operation = sc.next();
            if ("insert".equals(operation)) {
                String word = sc.next();
                trie.insert(word);
            }else if ("search".equals(operation)) {
                String word = sc.next();
                System.out.println(trie.search(word));
            }else if ("startsWith".equals(operation)) {
                String prefix = sc.next();
                System.out.println(trie.startsWith(prefix));
            }
        }
    }
}
