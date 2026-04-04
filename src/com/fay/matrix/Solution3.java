package com.fay.matrix;

public class Solution3 {
    public void rotate(int[][] matrix) {
        // 矩阵阶数
        int n = matrix.length;
        // 矩阵转置
        for (int i = 0; i < n; i++) {
            // 只需要交换主对角线下方的元素
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 进行行翻转，关于中轴对称元素交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
