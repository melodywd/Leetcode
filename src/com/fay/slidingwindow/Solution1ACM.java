package com.fay.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        // 定义一个哈希集合，用来记录出现过的字符和索引
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int res = 0;
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                left = Math.max(left, map.get(array[i]) + 1);
            }
            map.put(array[i], i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
