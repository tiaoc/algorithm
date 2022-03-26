package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<int[]> queue = new ArrayList<>();
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> pos = new HashSet<>();
        HashSet<Integer> neg = new HashSet<>();
        dfs(0, n, queue, col, pos, neg, res);
        return res;
    }

    private void dfs(int row, int n, ArrayList<int[]> queen, HashSet<Integer> col, HashSet<Integer> pos, HashSet<Integer> neg, List<List<String>> res) {
        if (queen.size() == n) {
            List<String> temp = genarator(queen);
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !pos.contains(row - i) && !neg.contains(row + i)) {
                queen.add(new int[]{row, i});
                col.add(i);
                pos.add(row-i);
                neg.add(row+i);
                dfs(row + 1, n, queen, col, pos, neg, res);
                queen.remove(queen.size()-1);
                col.remove(i);
                pos.remove(row-i);
                neg.remove(row+i);
            }
        }
    }

    private List<String> genarator(List<int[]> queen) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queen.size(); i++) {
            char[] cur = new char[queen.size()];
            Arrays.fill(cur, '.');
            cur[queen.get(i)[1]] = 'Q';
            res.add(new String(cur));
        }
        return res;
    }
}
