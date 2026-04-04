package com.fay.matrix;

public class Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 矩阵行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 循环变量
        int i = 0,j = n - 1;
        // 右上角开始遍历，大于目标值列减，小于目标值行加
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            }else if (matrix[i][j] < target) {
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
