package com.fay.array;
import java.util.*;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] intervals = new  int[m][2];
        for (int i = 0; i < m; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        res.add(intervals[0]);
        for (int[] p : intervals) {
            int n = res.size();
            if ( p[0] <= res.get(n-1)[1]) {
                res.get(n-1)[1] = Math.max(p[1], res.get(n-1)[1]);
            }else {
                res.add(p);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
