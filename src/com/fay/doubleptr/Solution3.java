package com.fay.doubleptr;
import java.util.Stack;

public class Solution3 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }
    public static int trap1(int[] height) {
        // 单调栈存入索引
        Stack<Integer> s = new Stack<>();
        int temp = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 遇到比栈顶高的柱子，开始收集雨水
            while (!s.isEmpty() && height[s.peek()] <= height[i]) {
                // 弹出栈顶，并存入临时变量
                temp = height[s.peek()];
                s.pop();
                // 栈不为空，收集雨水
                if (!s.isEmpty()) {
                    int h = Math.min(height[s.peek()], height[i]) - temp;
                    int w = i - s.peek() - 1;
                    res += h * w;
                }
            }
            s.push(i);
        }
        return res;
    }
    public static int trap2(int[] height) {
        int res = 0;
        // 双指针
        int left = 0;
        int right = height.length - 1;
        // 前缀和后缀的最大值，随着指针移动而更新
        int preMax = 0;
        int sufMax = 0;

        while (left < right) {
            // 更新前缀和后缀最大值
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                res += preMax - height[left];
                left++;
            }else {
                res += sufMax - height[right];
                right--;
            }
        }
        return res;
    }
}
