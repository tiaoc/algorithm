package com.lcp;

import java.util.Arrays;

public class S02 {
    public static void main(String[] args) {
//        int[] materials = new int[]{3,2,4,1,2} ;
//        int[][] cookbooks=new int[][]{{1,1,0,1,2},{2,1,4,0,0},{3,2,4,1,0}} ;
//        int[][] attribute=new int[][]{{3,2},{2,4},{7,6}};
        int[] materials = new int[]{10, 10, 10, 10, 10};
        int[][] cookbooks = new int[][]{{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {10, 10, 10, 10, 10}};
        int[][] attribute = new int[][]{{5, 5}, {6, 6}, {10, 10}};
        System.out.println(new S02().perfectMenu(materials, cookbooks, attribute, 1));
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        return dfs(0, materials, cookbooks, attribute, limit);
    }

    //返回满足不饿的最大美味
    private int dfs(int cur, int[] materials, int[][] cookbooks, int[][] attribute,
                    int limit) {
        if (cur == cookbooks.length) {
            if (limit > 0) {
                return -1;
            }
            return 0;
        }
        int deli = 0, res = 0;
        int temp = dfs(cur + 1, Arrays.copyOf(materials, materials.length), cookbooks, attribute, limit);
        if (temp != -1) {
            res = temp;
        }
        for (int i = 0; i < cookbooks[cur].length; i++) {
            if (materials[i] < cookbooks[cur][i]) {
                if (limit > 0&&res==0) {
                    return -1;
                }
                return res;
            } else {
                materials[i] -= cookbooks[cur][i];
            }
        }
        deli += attribute[cur][0];
        limit -= attribute[cur][1];
        int t = dfs(cur + 1, Arrays.copyOf(materials, materials.length), cookbooks, attribute, limit);
        if (t != -1) {
            res = Math.max(deli + t, res);
        }
        if(res ==0){
            return -1;
        }
        return res;
    }
}
