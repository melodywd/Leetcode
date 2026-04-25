package com.fay.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // 哈希表存入数组元素和出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0 ) + 1);
        }

        // 小顶堆存入 k 个频率最高的 元素 和 频率
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,  b) -> a[1] - b[1]);
        for (Integer key : map.keySet()) {
            int num = key;
            int count = map.get(key);
            // 数组元素和频率入堆
            pq.offer(new int[]{num, count});
            // 如果堆中元素大于 k ，弹出堆顶
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
