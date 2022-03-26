package com.toOffer01;

import java.util.Arrays;

public class code29 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4}, { 5, 6,7,8}, { 9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int right = matrix[0].length - 1, down = matrix.length - 1, left = 0, up = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (up < down && left < right) {
            for (int i = left; i <= right; i++) {
                result[index] = matrix[up][i];
                index++;
            }
            for (int i=up+1;i<=down-1;i++){
                result[index] = matrix[i][right];
                index++;
            }
            for (int i = right; i >= left; i--) {
                result[index] = matrix[down][i];
                index++;
            }
            for (int i=down-1;i>=up+1;i--){
                result[index] = matrix[i][left];
                index++;
            }
            up++;
            down--;
            left++;
            right--;
        }
        if (up < down&&left==right) {
            for (int i = up; i <= down; i++) {
                result[index] = matrix[i][left];
                index++;
            }
        }
        if (left<right&&up==down) {
            for (int i = left; i <= right; i++) {
                result[index] = matrix[up][i];
                index++;
            }
        }
        if(up == down&&left==right) result[index] = matrix[up][left];
        return result;
    }
}
