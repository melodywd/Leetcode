package com.fay.dp;
import java.util.Scanner;

public class Solution5ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if ( coins.length == 0 ) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j : coins) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
