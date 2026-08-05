package com.fay.dp;

import java.util.*;

public class Solution6ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        System.out.println(wordBreak(s, list));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
