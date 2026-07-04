package com.fay.multidp;

public class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        // 状态数组 dp[i][j] 表示 text1 的前 i 个字符 和 text2 的前 j 个字符 的最长公共子序列长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 判断text1第 i 个和text2第 j 个字母是否相等
                if (s1[i - 1] == s2[j - 1]) {
                    // 相等则都选上
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    // 不相等则选一个
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}

