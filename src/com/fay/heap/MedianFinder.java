package com.fay.heap;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> p,q;
    public MedianFinder() {
        // 小顶堆，存较大的一半
        p = new PriorityQueue<>();
        // 大顶堆，存较小的一半
        q = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        // p 中元素比 q 多一个
        if (p.size() != q.size()) {
            p.add(num);
            q.add(p.poll());
        }else {
            // 两个堆元素个数相等
            q.add(num);
            p.add(q.poll());
        }
    }

    public double findMedian() {
        return p.size() == q.size() ? (p.peek() + q.peek())/2.0 : p.peek();
    }
}
