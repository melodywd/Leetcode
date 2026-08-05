package com.fay.dp;
import java.util.*;

public class Solution10ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
