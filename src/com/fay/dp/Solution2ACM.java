package com.fay.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generate(n));
    }
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
