package com.fay.backtrack;
import java.util.*;

public class Solution6ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String word = sc.next();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
       return false;
    }
    public static boolean dfs(int i, int j, int k, char[][] board, String word) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        board[i][j] = '0';
        boolean res = dfs(i + 1, j, k + 1, board, word) ||
                dfs(i - 1, j, k + 1, board, word) ||
                dfs(i, j - 1, k + 1, board, word) ||
                dfs(i, j + 1, k + 1, board, word);
        board[i][j] = word.charAt(k);
        return res;
    }
}
