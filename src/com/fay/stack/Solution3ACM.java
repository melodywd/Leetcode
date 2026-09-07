package com.fay.stack;
import java.util.*;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }
        int[] res = dailyTemperatures(temperatures);
        for (int num : res) {
            System.out.println(num);
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
