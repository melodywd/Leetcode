package com.fay.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        // 创建一个set集合，将数组元素添加进set集合中
        for (int num : nums) {
            s.add(num);
        }
        // 记录最长连续序列的长度
        int ans = 0;
        for (int x : s){
            if (s.contains(x - 1)){
                // 如果x-1在set集合，跳过，连续子序列起点不可能是x
                continue;
            }
            // 依次递增x，寻找连续子序列的终点y-1
            int y = x + 1;
            while (s.contains(y)){
                y++;
            }
            ans = Math.max(y - x, ans);
        }
        return ans;
    }
}
