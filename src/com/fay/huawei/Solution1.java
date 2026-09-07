package com.fay.huawei;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<int[]> ans = longestStableIntervals(nums);
        // 如果不存在合法区间
        if (ans.isEmpty()) {
            System.out.println("-1 -1");
            return;
        }
        // 按起始索引从小到大输出
        for (int[] interval : ans) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    public static List<int[]> longestStableIntervals(int[] nums) {
        List<int[]> ans = new ArrayList<>();

        // maxDeque：维护当前窗口最大值，下标对应的值单调递减
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // 维护最大值单调队列
            while (!maxDeque.isEmpty() && nums[maxDeque.peek()] < nums[right]) {
                maxDeque.poll();
            }
            maxDeque.offer(right);
            // 维护最小值单调队列
            while (!minDeque.isEmpty() && nums[minDeque.peek()] > nums[right]) {
                minDeque.poll();
            }
            minDeque.offer(right);

            int min = nums[minDeque.peek()];
            int max = nums[maxDeque.peek()];
            while (left <= right && (min < 18 || max > 24 || max - min > 4)) {
                if (!maxDeque.isEmpty() && maxDeque.peek() == left) {
                    maxDeque.poll();
                }
                if (!minDeque.isEmpty() && minDeque.peek() == left) {
                    minDeque.poll();
                }
                left++;
            }
            if (left <= right) {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                    ans.clear();
                    ans.add(new int[]{left, right});
                } else if (len == maxLen) {
                    ans.add(new int[]{left, right});
                }
            }
        }
        return ans;
    }
}