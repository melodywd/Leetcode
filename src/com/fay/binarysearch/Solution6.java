package com.fay.binarysearch;

public class Solution6 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是短的那个数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        // 奇数或偶数中位数的位置
        int half = (m + n + 1)/2;
        // 二分查找边界，闭区间
        int left = 0;
        int right = m;
        while (left <= right) {
            // 两个数组切割线的位置
            int i = (left + right)/2;// 左边 i 个数
            int j = half - i;// 左边 j 个数
            // 考虑边界，切割线左边或右边没有数字
            // 没有数字一边设置为最小值或最大值，使满足判断条件
            int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            // 满足条件：切割线左边数小于等于右边
            if (l1 <= r2 && l2 <= r1) {
                if ( (m+n) % 2 == 1) {
                    return Math.max(l1,l2);
                }else {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            }else if (l1 > r2) {
                right = i - 1;
            }else {
                left = i + 1;
            }
        }
        return 0;
    }
}
