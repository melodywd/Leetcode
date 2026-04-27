package com.fay.greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // 统计字符串中字母出现的最后下标
        int[] last = new int[26];
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            last[ch[i] - 'a'] = i;
        }
        // 区间的左右端点
        int start = 0;
        int end = 0;
        for (int i = 0; i < ch.length; i++) {
            // 区间右端点为字母最后出现下标的最大值
            end = Math.max(end, last[ch[i] - 'a']);
            if (i == end) {
                // 记录区间长度
                res.add(end - start + 1);
                // 下一区间起点
                start = end + 1;
            }
        }
        return res;
    }
}
