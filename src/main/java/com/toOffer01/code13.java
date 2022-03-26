package com.toOffer01;

public class code13 {
    public static void main(String[] args) {
        int m = 2, n = 3, k = 1;
        System.out.println(movingCount(m,n,k));
    }
    public static int movingCount(int m, int n, int k) {
        int[][]map = new int [m][n];
        int result=help(0,0,m,n,k,map);
        return result;
    }

    public static int help(int row,int col,int m,int n,int k,int[][] map) {
        int count=0;
        if(row>=0 && row<m && col>=0 && col<n && check(row,col,k) && map[row][col]==0){
            map[row][col]=1;
            count++;
            count+=help(row-1,col,m,n,k,map);
            count+=help(row+1,col,m,n,k,map);
            count+=help(row,col-1,m,n,k,map);
            count+=help(row,col+1,m,n,k,map);
        }
        return count;

    }
    public static boolean check(int row,int col,int k){
        int temp;
        int count=0;
        while(row>=1){
            temp=row%10;
            row=row/10;
            count+=temp;
        }
        while(col>=1){
            temp=col%10;
            col=col/10;
            count+=temp;
        }
        if (count>k){
            return false;
        }else return true;
    }
}
