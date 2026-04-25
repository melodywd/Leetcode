package com.fay.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {
    private int res;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 四方向

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 统计新鲜橘子
                    fresh++;
                }else if (grid[i][j] == 2){
                    // 腐烂橘子放在队列
                    q.offer(new int[]{i,j});
                }
            }
        }
        while (fresh > 0 && !q.isEmpty()) {
            res++;
            int size = q.size();
            // 只遍历当前腐烂的橘子
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                // 感染四方向的橘子
                for (int[] d : DIRECTIONS) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    // 不越界且是新鲜橘子
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        // 感染新鲜橘子并加入队列
                        fresh--;
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                    }
                }
            }

        }
        return fresh > 0 ? -1 : res;
    }

}
