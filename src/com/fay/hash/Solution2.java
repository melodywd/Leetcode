package com.fay.hash;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 遍历字符串数组，排序后，将排序后的字符串作为key，将原字符串作为value
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 排序字符串，创建新的字符串对象
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newString = new String(array);
            // getOrDefault方法，如果key存在，则返回对应的value；如果key不存在，则返回默认值（这里是一个新的ArrayList）
            List<String> list = map.getOrDefault(newString, new ArrayList<String>());
            list.add(str);
            // 将newString作为key，更新list作为value，添加进map中
            map.put(newString, list);
        }
        return new ArrayList<List<String>>(map.values());

    }
}
