package com.fay.binarysearch;

public class Solution2 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        // 矩阵行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 二分查找区间，闭区间
        int left = 0, right = m * n - 1;
        while (left <= right) {
            // 区间中间元素在数组中的位置
            int mid = left + (right - left)/2;
            // 数组转换到矩阵索引 ———— i * n + j = mid
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }else if (x < target) {
                left = mid + 1;
            }else {
                right = mid -  1;
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        // 矩阵行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 初始化为右上角元素
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}

