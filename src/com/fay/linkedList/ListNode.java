package com.fay.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode () {};
    ListNode (int x) {
        this.val = x;
    }
    ListNode(int x,ListNode node) {
        this.val = x;
        this.next = node;
    }
}
