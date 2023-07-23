package com.server2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode6472 {
    // 行受查询或列受查询
    // 列被查询则整列被查询
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        long res = 0;
        for (int i = queries.length - 1; i >= 0; i --) {
            int type = queries[i][0];
            int idx = queries[i][1];
            int val = queries[i][2];
            if (type == 0) {
                if(row.contains(idx)){
                    continue;
                }
                res += (long) val * (n-col.size());
                row.add(idx);
            } else {
                if(col.contains(idx)){
                    continue;
                }
                res += (long) val * (n-row.size());
                col.add(idx);
            }
        }
        return res;
    }
}
