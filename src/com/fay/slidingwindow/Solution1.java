package com.fay.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {

    }
    public static int lengthOfLongestSubstring(String s) {
        // 定义一个哈希集合，用来记录出现过的字符和索引
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int i = 0;
        // 记录子串长度
        int res = 0;
        for (int j = 0; j < ch.length; j++) {
            if (map.containsKey(ch[j])){
                // 更新窗口左端点为重复元素下一位，但不能左移
                i = Math.max(map.get(ch[j]) + 1, i);
            }
            map.put(ch[j],j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
