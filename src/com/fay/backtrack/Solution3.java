package com.fay.backtrack;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    private static final String[] LETTERS = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        // 字符数组
        char[] path = new char[n];
        dfs(0, digits, ans, path);
        return ans;
    }
    public void dfs(int i, String digits, List<String> ans, char[] path) {
        // 递归边界
        if (i == digits.length()) {
            ans.add(new String(path));
            return;
        }
        // 找到数字对应字母的数组
        char[] charArray = LETTERS[digits.charAt(i) - '2'].toCharArray();
        for (char c : charArray) {
            // 直接覆盖，无需撤销操作
            path[i] = c;
            // 下一个数字
            dfs(i+1, digits, ans, path);
        }

    }
}
