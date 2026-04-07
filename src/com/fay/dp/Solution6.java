package com.fay.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 状态数组 dp，dp[i]表示字符串前i个字符组成的单词是否可由字典单词组成
        boolean[] dp = new boolean[s.length()+1];
        // 哈希表存储字典的单词
        Set<String> wordsSet = new HashSet<>(wordDict);
        // 初始状态，空字符串必然可被拆分
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // j从0到i切割字符串，判断dp[j]是否可拆分 和 j到i的字符串 是否在字典中
            for (int j = 0; j < i; j++) {
                // 状态转移方程 dp[i] = dp[j] && wordsSet.contains(s.substring(j,i))
                if (dp[j] && wordsSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
