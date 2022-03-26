package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{2,2},{1,1},{0,0},{2,0}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    count=-1;
                }
            }
        }
        System.out.println(count);
        while(!queue.isEmpty()){
            Queue<int[]> queue2=queue;
            queue=new LinkedList<>();
            while(!queue2.isEmpty()){
                int[] orange=queue2.poll();
                System.out.println(Arrays.toString(orange));
                int i=orange[0],j=orange[1];
                grid[i][j]=2;
                if(i+1<m&&grid[i+1][j]==1){
                    queue.add(new int[]{i+1,j});
                }
                //System.out.println(j);
                if(i-1>=0&&grid[i-1][j]==1){
                    queue.add(new int[]{i-1,j});
                }
                if(j+1<n&&grid[i][j+1]==1){
                    queue.add(new int[]{i,j+1});
                }
                if(j-1>=0&&grid[i][j-1]==1){
                    queue.add(new int[]{i,j-1});
                }
            }
            count++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count;
    }
}
