package com.leetcode;

import java.util.*;

public class leetcode5852 {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m=mat.length,n=mat[0].length;
        HashSet<Integer> pre=new HashSet<>();
        for(int j=0;j<n;j++){
            pre.add(mat[0][j]);
        }
        HashSet<Integer> cur;
        for(int i=1;i<m;i++){
            cur=new HashSet<>();
            for (int key : pre) {
                Arrays.sort(mat[i]);
                for (int j = 0; j < n; j++) {
                    cur.add(key + mat[i][j]);
                    if (key + mat[i][j] > target) {
                        break;
                    }
                }
            }
            pre=cur;
        }
        int res=Integer.MAX_VALUE;
        for (int key : pre) {
            res=Math.min(res,Math.abs(key - target));
        }
        return res;
    }
}
