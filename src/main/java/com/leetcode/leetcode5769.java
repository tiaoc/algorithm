package com.leetcode;

import java.util.Arrays;

public class leetcode5769 {
    //以某个点位左上角的正方形方格
    //正方形，向右下增加，未必要满足之前的小正方形是幻方
    //记录每个正方形的行列对角线。k个行列，两个对角线
    //如何避免重复计算？前缀和可以吗？
    //计算每个点到最左边的前缀和--行
    //每个点到最上的前缀和--列
    //对角线？也是可以的。
    //
    public static void main(String[] args) {
        int[][]grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(largestMagicSquare(grid));
    }
    public static int largestMagicSquare(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][]rows=new int[m][n];
        int[][]cols=new int[m][n];
        int[][]tris=new int[m][n];
        for(int i=0;i<m;i++){
            int cur=0;
            for(int j=0;j<n;j++){
                cur+=grid[i][j];
                rows[i][j]=cur;
            }
        }
        for(int j=0;j<n;j++){
            int cur=0;
            for(int i=0;i<m;i++){
                cur+=grid[i][j];
                cols[i][j]=cur;
            }
        }
        for(int i=0;i<m;i++){
            int cur=0;
            for(int j=0;i+j<m;j++){
                cur+=grid[i+j][j];
                tris[i+j][j]=cur;
            }
        }
        for(int j=0;j<n;j++){
            int cur=0;
            for(int i=0;i+j<n&&i<m;i++){
                cur+=grid[i][i+j];
                tris[i][i+j]=cur;
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=Math.min(m-i-1,n-j-1);k>res;k--){
                    int r=0,c=0,t=0;
                    if(i>0&&j>0){
                        r=rows[i-1][j-1];
                        c=cols[i-1][j-1];
                        t=tris[i-1][j-1];
                    }
                    boolean flag=true;
                    for(int cc=i;cc<i+k-1;cc++){
                        if(rows[cc][j+k]-rows[cc][j]!=rows[cc-1][j+k]-rows[cc-1][j]){
                            flag=false;
                            break;
                        }
                    }
                    if(!flag){
                        break;
                    }
                    for(int rr=j;rr<j+k-1;rr++){
                        if(rows[i+k][rr]-rows[i-1][rr]!=rows[i+k][rr]-rows[i-1][rr]){
                            flag=false;
                            break;
                        }
                    }
                    
                }
            }
        }
        for(int i=0;i<m;i++) {
            System.out.println(Arrays.toString(rows[i]));
        }
        for(int i=0;i<m;i++) {
            System.out.println(Arrays.toString(cols[i]));
        }
        for(int i=0;i<m;i++) {
            System.out.println(Arrays.toString(tris[i]));
        }
        return res;
    }
}
