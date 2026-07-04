package com.fay.multidp;

public class Solution5 {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        // 状态数组 dp[i][j] 表示 word1 的前 i 个字符转换到word2 的前 j 个字符的最少编辑次数
        int[][] dp = new int[m+1][n+1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // 遍历状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i-1] == s2[j-1]) {
                    // 相等不用编辑
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 替换、插入、删除
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

