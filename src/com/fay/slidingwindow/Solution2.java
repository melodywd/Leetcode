package com.fay.slidingwindow;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        // 哈希表存入26位小写字母出现次数
        int[] cntp = new int[26];
        int[] cnts = new int[26];
        // 遍历p字符串，出现字母，相应位置加1
        for (int i = 0; i < pLen; i++) {
            cntp[p.charAt(i) - 'a']++;
        }
        // 左指针窗口起点
        int l = 0;
        // 固定长度pLen在s字符串中滑动窗口
        for (int r = 0; r < sLen; r++) {
            cnts[s.charAt(r) - 'a']++;
            // 判断窗口长度
            if (r - l + 1 < pLen) {
                continue;
            }
            if (Arrays.equals(cnts, cntp)){
                ans.add(l);
            }
            // 哈希数组更新窗口左端点
            cnts[s.charAt(l) - 'a']--;
            l++;
        }
        return ans;
    }
}
