package com.fay.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        // 字符数组，回退时只需覆盖
        char[] path = new char[2*n];
        dfs(0, 0, n, ans, path);
        return ans;
    }
    public static void dfs(int left, int right, int n, List<String> ans, char[] path) {
        // 递归边界————填完所有括号
        if (right == n) {
            ans.add(new String(path));
            return;
        }
        // 选左括号
        if (left < n) {
            // 直接覆盖，不用撤销
            path[left + right] = '(';
            dfs(left + 1, right, n, ans, path);
        }
        // 选右括号
        if (right < left) {
            path[left + right] = ')';
            dfs(left, right + 1, n, ans, path);
        }
    }
}
