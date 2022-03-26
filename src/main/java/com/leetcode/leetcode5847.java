package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode5847 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new leetcode5847().findFarmland(new int[][]{{1, 1}, {0, 0}})));
    }
    ArrayList<int[]> res=new ArrayList<>();
    boolean[][] visited;
    public int[][] findFarmland(int[][] land) {
        int m=land.length,n=land[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int[] rightEdge=dfs(land,i,j);
                if(rightEdge.length!=0){
                    res.add(new int[]{i,j,rightEdge[0],rightEdge[1]});
                }
            }
        }
        int[][] ans=new int[res.size()][4];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
    private int[] dfs(int[][] nums,int row,int col){
        if(row<0||row>=nums.length||col<0||col>=nums[0].length){
            return new int[0];
        }
        if(visited[row][col]){
            return new int[0];
        }
        visited[row][col]=true;
        if(nums[row][col]==0){
            return new int[0];
        }
        int[] a=dfs(nums,row+1,col);
        int[] b=dfs(nums,row,col+1);
        int rightRow=row,rightCol=col;
        if(a.length!=0){
            rightRow=Math.max(rightRow,a[0]);
            rightCol=Math.max(rightCol,a[1]);
        }
        if(b.length!=0){
            rightRow=Math.max(rightRow,b[0]);
            rightCol=Math.max(rightCol,b[1]);
        }
        return new int[]{rightRow,rightCol};
    }
}
