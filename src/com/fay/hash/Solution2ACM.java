package com.fay.hash;

import java.util.*;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            strs[i] = s;
        }
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            // 转成字符数组并排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            List<String> list = res.getOrDefault(newString, new ArrayList<>());
            list.add(s);
            res.put(newString,list);
        }
        return new ArrayList<>(res.values());
    }
}
