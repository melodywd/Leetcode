package com.fay.backtrack;
import java.util.*;

public class Solution5ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2*n];
        dfs(0, 0, n, ans, path);
        return ans;
    }
    public static void dfs(int left, int right, int n, List<String> ans, char[] path) {
        if (right == n) {
            ans.add(new String(path));
            return;
        }
        if (left < n) {
            path[left + right] = '(';
            dfs(left + 1, right, n, ans, path);
        }
        if (right < left) {
            path[left + right] = ')';
            dfs(left, right + 1, n, ans, path);
        }
    }
}
