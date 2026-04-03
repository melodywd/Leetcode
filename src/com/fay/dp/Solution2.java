package com.fay.dp;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        // 结果集合
        List<List<Integer>> resList = new ArrayList<>();
        // 初始化第一行为1
        resList.add(List.of(1));
        // 杨辉三角
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            // 每行个数 = 行数 + 1；
            for (int j = 1; j < i; j++) {
                list.add(resList.get(i-1).get(j-1) + resList.get(i-1).get(j));
            }
            list.add(1);
            resList.add(list);
        }
        return resList;
    }
}
