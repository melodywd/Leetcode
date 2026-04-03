package com.fay.dp;

public class Solution1 {
    public int climbStairs(int n) {
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
