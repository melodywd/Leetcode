package com.fay.matrix;

public class Solution1 {
    public static void main(String[] args) {

    }

    /**
     * 方法1：空间复杂度 O(m+n)
     * 方法2：空间复杂度 O(1)
     */
    public static void setZeroes1(int[][] matrix) {
        // 行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义两个数组标记行和列是否有0
        boolean[] rowZero = new boolean[m];
        boolean[] colZero = new boolean[n];
        // 遍历矩阵，标记行和列是否有0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = colZero[j] = true;
                }
            }
        }
        // 开始置0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // i行或j列有0
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public static void setZeroes2(int[][] matrix) {
        // 行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义两个标记变量，记录第一行和第一列是否有0
        boolean firstRowZero = false;
        boolean firstColZero = false;
        // 判断第一行是否有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // 判断第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // 判断剩下的行和列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果有0,则把这一行和列的首元素标记为零
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 开始置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 第一行和第一列
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
