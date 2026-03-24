package com.fay.linkedList;

public class Solution1 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 定义两个指针，分别从A、B两个结点遍历
        ListNode skipA = headA;
        ListNode skipB = headB;
        while (skipA != skipB) {
            // 遍历完接着遍历另一个节点，直到走到相交结点或者末尾
            skipA = skipA == null ? headB : skipA.next;
            skipB = skipB == null ? headA : skipB.next;
        }
        return skipA;
    }
}
