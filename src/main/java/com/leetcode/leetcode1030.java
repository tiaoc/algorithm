package com.leetcode;

import java.util.Arrays;

public class leetcode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res=new int[R*C][2];
        int t=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                res[t]= new int[]{i, j};
                t++;
            }
        }
        Arrays.sort(res,(o1,o2)->{
            return Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0)-Math.abs(o2[0]-r0)-Math.abs(o2[1]-c0);
        });
        return res;
    }
}
