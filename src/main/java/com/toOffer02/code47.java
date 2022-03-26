package com.toOffer02;

public class code47 {
    public static void main(String[] args) {
        int[][] array={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(array));
    }
    public static int maxValue(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int[][] maxValues=new int[m][n];
        int left=0,up=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){//i,j能到达的最大值
                if(i<m-1){
                    left=maxValues[i+1][j]+grid[i+1][j];
                }else {
                    left=0;
                }
                if(j<n-1){
                    up=maxValues[i][j+1]+grid[i][j+1];
                }else {
                    up=0;
                }
                maxValues[i][j]=Math.max(left,up);
            }
        }
        return maxValues[0][0]+grid[0][0];
    }
}
