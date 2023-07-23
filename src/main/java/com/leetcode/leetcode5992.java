package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * leetcode2151. 基于陈述统计最多好人数
 */
public class leetcode5992 {
    // 对某人的陈述，每个人为源，考虑最大出现多少个好人
    // 对某个人的陈述，他对别人的陈述，dfs
    // 对其陈述真假，如果为真，继续加入，为假不管
    public static void main(String[] args) {
        int[][] n = new int[][]{{2, 1, 2}, {1, 2, 2}, {2, 0, 2}};
        System.out.println(maximumGood(n));
//        int[][] n1 = new int[][]{{2, 0, 2, 2, 0}, {2, 2, 2, 1, 2}, {2, 2, 2, 1, 2}, {1, 2, 0, 2, 2}, {1, 0, 2, 1, 2}};
//        System.out.println(maximumGood(n1));
//        int[][] n2 = new int[][]{{2, 2}, {2, 2}};
//        System.out.println(maximumGood(n2));
//        int[][] n3 = new int[][]{{2, 2, 2, 2}, {1, 2, 1, 0}, {0, 2, 2, 2,}, {0, 0, 0, 2}};
//        System.out.println(maximumGood(n3));
        int[][] n4 = new int[][]{{2, 2, 2, 2, 0, 1, 2, 0, 0, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 0, 2, 2, 0, 1, 0, 2, 2, 1}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {1, 0, 1, 0, 2, 2, 2, 0, 0, 1}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 0, 1, 2, 2, 1, 2, 2, 2, 2}};
        System.out.println(maximumGood(n4));
    }

    public static int maximumGood(int[][] statements) {
        int n = statements.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 每个i是好人为源
            int[] visited = new int[n];
            Arrays.fill(visited, 2);
            visited[i] = 1;
            int tRes = dfs(statements, i, visited, 1);
            visited[i] = 1;
            int count = 0;
            // 判断visited中为2的位置，让这些位置符合之前的人visited中的判断
            for (int j = 0; j < n; j++) {
                if (visited[j] == 2) {
                    int[] v2 = Arrays.copyOf(visited, n);
                    v2[j] = 1;
                    int newCount= dfs(statements, j, v2, 1);
                    count = Math.max(count, newCount);
                }
            }
            res = Math.max(res, tRes + count);
        }
        return res;
    }

    //只顺序判断某个位置是好人？
    private static int dfs(int[][] statements, int cur, int[] visited, int curCount) {
        if (visited[cur] == 0) {
            return 0;
        }
        int pCount = curCount;
        for (int j = 0; j < statements.length; j++) {
            // cur是好人，说j是好人
            if (statements[cur][j] == 1) {
                // 之前判断j是坏人
                if (visited[j] == 0) {
                    return 0;
                }
                // 之前判断j是未知
                if (visited[j] == 2) {
                    visited[j] = 1;
                    pCount = dfs(statements, j, visited, curCount + 1);
                    if (pCount == 0) {
                        return 0;
                    }
                }
                // cur是好人，说j是坏人
            } else if (statements[cur][j] == 0) {
                // 之前判断j是好人
                if (visited[j] == 1) {
                    return 0;
                }
                visited[j] = 0;
            } else {
                
            }
        }
        return pCount;
    }

}
