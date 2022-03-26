package com.leetcode;

public class leetcode5735 {
    //有几个负数，找绝对值最小的作为负值（奇数个负值）
    public long maxMatrixSum(int[][] matrix) {
        long res=0;
        int min=Integer.MAX_VALUE,count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    res+=-matrix[i][j];
                    count++;
                }else{
                    res+=matrix[i][j];
                }
                min=Math.min(Math.abs(matrix[i][j]),min);
            }
        }
        if(count%2==1){
            return res-2*min;
        }
        return res;
    }
}
