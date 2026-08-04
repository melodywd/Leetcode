package com.fay.dp;

import java.util.Scanner;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        // 初始状态
        if (n==1||n==2) {
            return n;
        }
        int sum =0;
        int a=1;
        int b=2;
        for (int i = 3; i <= n;i++) {
            // 转移方程，压缩空间为 O(1)
            sum = a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
