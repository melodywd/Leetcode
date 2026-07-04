package com.fay.greedy;

public class Solution1 {
    public int maxProfit(int[] prices) {
        // 成本和利润
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            // 成本为目前最低值
            cost = Math.min(cost, price);
            // 利润
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
