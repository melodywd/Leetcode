package com.fay.backtrack;

public class Solution6 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCES";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int i, int j, int k, char[][] board, String word) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        // 遍历完就改值，防止重复搜索
        board[i][j] = '0';
        // 递归上下左右四个方向
        boolean res = dfs(i + 1, j, k + 1, board, word)
                      || dfs(i, j + 1, k + 1, board, word)
                      || dfs(i - 1, j, k + 1, board, word)
                      || dfs(i, j - 1, k + 1, board, word);
        // 回退，改回原来的字母
        board[i][j] = word.charAt(k);
        return res;
    }
}
