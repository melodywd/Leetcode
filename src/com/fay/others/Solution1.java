package com.fay.others;

public class Solution1 {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
}
