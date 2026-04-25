package com.fay.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution4 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 栈存索引，存入还没找到更大元素的索引
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            // 遇到更大的元素就弹出栈，记录结果
            while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            // 否则入栈
            stack.push(i);
        }
        return ans;
    }
}
