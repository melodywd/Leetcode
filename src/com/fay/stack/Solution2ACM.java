package com.fay.stack;
import java.util.*;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 将'['前面的字符和数字存入栈
                stack1.push(res.toString());
                stack2.push(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int num = stack2.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack1.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
