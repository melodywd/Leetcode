package com.fay.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> p,q;
    public MedianFinder() {
        // 小顶堆，存较大的一半
        p = new PriorityQueue<>();
        // 大顶堆，存较小的一半
        q = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        // 交替加入堆
        if (p.size() != q.size()) {
            p.offer(num);
            q.offer(p.poll());
        }else {
            q.offer(num);
            p.offer(q.poll());
        }
    }

    public double findMedian() {
        return p.size() == q.size() ? (p.peek() + q.peek())/2.0 : p.peek();
    }

}
