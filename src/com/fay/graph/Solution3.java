package com.fay.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表：记录课程的后续课程（有向无环图）
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 入度数组，用于记录每门课程的入度
        int[] indegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            int cur = p[0];
            int pre = p[1];
            // 入度加1
            indegrees[cur]++;
            // 更新邻接表
            graph.get(pre).add(cur);
        }

        // 队列，存储入度为0的课程
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        // 记录完成的课程数
        int ans = 0;
        // BFS 遍历入度为0的课程
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans++;
            // 邻接表后续课程入度-1，如果入度为0加入队列
            for (Integer next : graph.get(cur)) {
                if (--indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return ans == numCourses;
    }
}
