package com.fay.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        // 结果集合
        List<int[]> ans = new ArrayList<>();
        // 排序数组左端点从小到大
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ans.add(intervals[0]);
        for (int[] p : intervals) {
            int m = ans.size();
            // 与结果集合中最后一个数组比较是否出现交集
            if (p[0] <= ans.get(m-1)[1]) {
                // 出现交集更新数组右端点
                ans.get(m-1)[1] = Math.max(ans.get(m-1)[1],p[1]);
            }else {
                // 没有交集加入集合
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
