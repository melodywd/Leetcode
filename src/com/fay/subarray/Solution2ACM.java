package com.fay.subarray;

import java.util.*;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if  (n == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            int left = i - k + 1;
            if (deque.getFirst() < left){
                deque.removeFirst();
            }
            if (left >= 0){
                res[left] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
