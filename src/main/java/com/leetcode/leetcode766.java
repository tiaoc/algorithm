package com.leetcode;

public class leetcode766 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        for(int i=m-1;i<n;i++){
            int j=i,count=0;
            while(count<m-1){
                System.out.println(j);
                if(matrix[j][j]!=matrix[j-1][j-1]){
                    return false;
                }
                j--;
                count++;
            }
        }
        return true;
    }
}
