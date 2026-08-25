package com.fay.backtrack;
import java.util.ArrayList;
import java.util.List;

public class Solution3ACM {
    private static final String[] LETTERS = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, digits, res, path);
        return res;
    }
    public static void dfs(int i, String digits, List<String> res, char[] path) {
        if (i == digits.length()) {
            res.add(new String(path));
            return;
        }
        char[] chars = LETTERS[digits.charAt(i) - '2'].toCharArray();
        for (char c : chars) {
            path[i] = c;
            dfs(i + 1, digits, res, path);
        }
    }
}
