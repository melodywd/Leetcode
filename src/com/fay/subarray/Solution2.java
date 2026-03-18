package com.fay.subarray;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义结果数组
        int[] res = new int[n - k + 1];
        // 定义双端队列，队首存储最大值索引
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 移除队列中比当前值小的索引，保持队列单调递减
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            // 当前元素的索引入队列
            deque.addLast(i);
            // 判断队列最左边的索引是否在滑动窗口外
            int left = i - k + 1;
            if (deque.getFirst() < left){
                deque.removeFirst();
            }
            // 形成窗口后，将当前队首索引对应元素加入结果数组
            if (left >= 0){
                res[left] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
