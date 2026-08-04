package com.fay.binarysearch;

import java.util.Scanner;

public class Solution6ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n+1)/2;

        int l = 0;
        int r = m;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;
            // i 表示数组分割线位置，左边有i个数
            // 边界是0和m
            int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (l1 <= r2 && l2 < r1) {
               if ((m+n)%2== 1) {
                   return Math.max(l1,l2);
               }else {
                   return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
               }
            }else if (l1 > r2) {
                r = i - 1;
            }else {
                l = i + 1;
            }
        }
        return 0;
    }
}
