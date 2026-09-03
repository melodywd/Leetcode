package com.fay.backtrack;
import java.util.*;

public class Solution7ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, ans, path);
        return ans;
    }
    public static void dfs(int i, String s, List<List<String>> ans,List<String> path) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, s, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
    // 判断是否为回文串
    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
