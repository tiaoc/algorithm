package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class leetcode5992 {
    // 对某人的陈述，每个人为源，考虑最大出现多少个好人
    // 对某个人的陈述，他对别人的陈述，dfs
    // 对其陈述真假，如果为真，继续加入，为假不管
    public static void main(String[] args) {
//        int[][] n = new int[][]{{2, 1, 2}, {1, 2, 2}, {2, 0, 2}};
//        System.out.println(maximumGood(n));
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
        int[] visited = new int[n];
        Arrays.fill(visited, 2);
        int tRes = dfs(statements, 0, visited, 1);
        res = Math.max(res, tRes);
        return res;
    }

    private static int dfs(int[][] statements, int cur, int[] visited, int curCount) {
        int nextCount, resCount = curCount;
        for (int j = 0; j < statements.length; j++) {
            if (statements[cur][j] == 1) {
                if (visited[j] == 0) {
                    return -1;
                }
                if (visited[j] == 2) {
                    nextCount = dfs(statements, j, visited, curCount + 1);
                    if (nextCount == -1) {
                        return -1;
                    }
                    resCount = Math.max(nextCount, resCount);
                }
            } else if (statements[cur][j] == 0) {
                if (visited[j] == 1) {
                    return -1;
                }
                visited[j] = 0;
            } else {
                continue;
            }
        }
        return resCount;
    }

}
