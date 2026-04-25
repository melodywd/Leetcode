package com.fay.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, ans, path);
        return ans;
    }
    public void dfs(int i, String s, List<List<String>> ans,List<String> path) {
        // 递归边界
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            // [i,j]是回文串，加入path
            if (isPalindrome(s, i, j)) {
                path.add(s.substring(i, j + 1));
                // 递归后面子串
                dfs(j + 1, s, ans, path);
                // 回退
                path.remove(path.size() - 1);
            }
        }
    }
    // 判断是否为回文串
    public boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
