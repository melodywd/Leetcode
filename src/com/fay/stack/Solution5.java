package com.fay.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution5 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 记录左边和右边最近的较小值
        int[] left = new int[n];
        int[] right = new int[n];
        // 遍历左边
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            // 记录每个矩形的左边界
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // 遍历右边
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            // 记录每个矩形的右边界
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
