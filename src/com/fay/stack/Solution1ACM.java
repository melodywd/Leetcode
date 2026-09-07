package com.fay.stack;
import java.util.*;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            }else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
