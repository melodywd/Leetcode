package com.fay.hash;
import java.util.*;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int x : nums) {
            // 起点不是x
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            // 更新长度
            res = Math.max(res, y - x);
        }
        return res;
    }
}
