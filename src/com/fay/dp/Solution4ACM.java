package com.fay.dp;
import java.util.Scanner;

public class Solution4ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numSquares(n));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}
