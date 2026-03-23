package com.fay.subarray;

public class Solution3 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        // 哈希表记录字母出现次数
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        // 记录 t 字符串的字母次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        // 滑动窗口左端点
        int left = 0;
        // 记录最小覆盖子串端点，用于截取字符串
        int  ansLeft = -1;
        int  ansRight = s.length();
        // 更新窗口端点
        for (int right = 0; right < s.length(); right++) {
            // 记录 s 字符串字母出现次数
            cntS[s.charAt(right)]++;
            while (isCovered(cntS,cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[s.charAt(left)]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight +1);
    }
    // 判断记录字母出现次数的数组是否包含
    public static boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i < 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i < 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
