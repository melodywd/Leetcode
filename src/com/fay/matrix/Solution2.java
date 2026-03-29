package com.fay.matrix;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义上下左右四个边界
        int t = 0, l = 0, r = n - 1, b = m - 1;
        // 结果数组
        Integer[] res = new Integer[m * n];
        int x = 0;
        while (true) {
            // 上行
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            // 上边界更新
            t++;
            if (t > b) break;
            // 右列
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            // 右边界更新
            r--;
            if (r < l) break;
            // 下行
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            // 下边界更新
            b--;
            if (t > b) break;
            // 左列
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            // 上边界更新
            l++;
            if (r < l) break;
        }
        return Arrays.asList(res);
    }
}
