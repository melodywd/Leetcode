package com.fay.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution10 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        // 用栈来存索引
        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;
        // 防止空栈，存入-1
        st.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // 左括号则压入栈
                st.push(i);
            }else {
                // 右括号则先弹出栈顶索引
                st.pop();
                // 栈为空，右括号没有匹配的，压入栈
                if (st.isEmpty() ) {
                    st.push(i);
                }else {
                    // 如果不为空，则更新括号长度
                    res = Math.max(i - st.peek(),res);
                }
            }
        }
        return res;
    }
}
