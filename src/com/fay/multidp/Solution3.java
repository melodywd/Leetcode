package com.fay.multidp;

public class Solution3 {
    public String longestPalindrome1(String s) {
        // 多维动态规划
        int n = s.length();
        char[] ch = s.toCharArray();
        // dp[i][j] 表示区间范围[i,j]的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        // i 从 n-1 开始往左遍历
        // j 从 i 往右遍历
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (ch[i] == ch[j]) {
                    // 情况一：长度小于等于3为回文串
                    if (j - i <= 2) dp[i][j] = true;
                    // 情况二：内层为回文串
                    else if (dp[i + 1][j - 1]) dp[i][j] = true;
                }
                // 更新长度
                if (dp[i][j] && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
    public String longestPalindrome2(String s) {
        // 中心扩展法
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = 0;
        // 奇数回文串
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            // 从中心扩展
            while (l >= 0 && r < n && ch[l] == ch[r]) {
                l--;
                r++;
            }
            if (r - l > right - left) {
                left = l + 1;
                right = r - 1;
            }
        }
        // 偶数回文串
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i + 1;
            // 从中心扩展
            while (l >= 0 && r < n && ch[l] == ch[r]) {
                l--;
                r++;
            }
            if (r - l > right - left) {
                left = l + 1;
                right = r - 1;
            }
        }
        return s.substring(left, right + 1);
    }
}
