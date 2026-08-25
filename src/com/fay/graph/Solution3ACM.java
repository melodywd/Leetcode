package com.fay.graph;
import java.util.*;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int n = sc.nextInt();
        int[][] prerequisites = new int[n][2];
        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 有向无环图
        List<List<Integer>> graph = new ArrayList<>();
        // 入度
        int[] inDegree = new int[numCourses];
        // 课程数
        int res = 0;
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int cur = p[0];
            int pre = p[1];
            inDegree[cur]++;
            graph.get(pre).add(cur);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res++;
            for (Integer nxt : graph.get(cur)) {
                inDegree[nxt]--;
                if (inDegree[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }
        return res == numCourses;
    }
}
