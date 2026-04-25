package com.fay.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public boolean isValid(String s) {
        // s 长度必须是偶数
        if (s.length() % 2 != 0) {
            return false;
        }
        // 哈希表存入右括号
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 如果是左括号，入栈
            if (!map.containsKey(c)) {
                st.push(c);
            }else if (st.isEmpty() || st.pop() != map.get(c)) {
                // 右括号
                // 栈为空或者栈顶左括号不对应
                return false;
            }
        }
        return st.isEmpty();
    }
}
