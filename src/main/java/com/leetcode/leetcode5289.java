package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class leetcode5289 {
    //尽可能平均分配
    //只区分组合 不区分具体哪个孩子
    //
    public static void main(String[] args) {
        System.out.println(new leetcode5289().distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
    }

    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        dfs(0, children, cookies);
        return res;
    }

    private void dfs(int cur, int[] children, int[] cookies) {
        if (cur == cookies.length) {
            int max = 0;
            for (int child : children) {
                max = Math.max(child, max);
            }
            res = Math.min(max, res);
            return;
        }
        for (int i = 0; i < children.length; i++) {
            children[i] += cookies[cur];
            dfs(cur + 1, children, cookies);
            children[i] -= cookies[cur];
        }
    }
}
