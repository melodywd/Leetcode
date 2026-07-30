package com.fay.matrix;

import java.util.Scanner;

public class Solution4ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            }else if (matrix[i][j] > target) {
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
}
