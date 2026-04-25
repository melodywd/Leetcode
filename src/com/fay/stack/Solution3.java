package com.fay.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public String decodeString(String s) {
        // 存入字符串和数字
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 栈存数字和前面的字符串用于后面拼接
        Deque<String> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if ( c == '[') {
                // 碰到左括号，将字符串和数字入栈
                stack1.push(res.toString());
                stack2.push(multi);
                // 存完再初始化
                multi = 0;
                res = new StringBuilder();
            }else if (c == ']') {
                int num = stack2.pop();
                // 碰到右括号，开始把[]内字符串解码
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack1.pop() + temp);
            }else if (c >= '0' && c <= '9') {
                // 数字
                multi = multi * 10 + Integer.parseInt(c + "");
            }else {
                // 字母
                res.append(c);
            }
        }
        return res.toString();
    }
}
