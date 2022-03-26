package com.leetcode;

import java.util.Arrays;

public class leetcode5744 {
    public static void main(String[] args) {
        char[][] box = new char[][]{{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}};
        System.out.println(Arrays.deepToString(rotateTheBox(box)));
    }
    //'#' 表示石头
    //'*' 表示固定的障碍物
    //'.' 表示空位置
    //就旋转了一次，小case
    //可能落在石头，障碍物，底部。
    //先从落在底部的开始判断。
    //不同行不会互相影响
    //遍历行开始处理
    //列下标大的在下面
    //石头会造成影响，每个石头的位置，
    //障碍物位置不变。
    //最后填充.
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length,n = box[0].length;
        char[][] res=new char[n][m];
        for(int i=0;i<m;i++) {
            char[] cur = new char[n];
            int lastEmpty = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    cur[lastEmpty] = '#';
                } else if (box[i][j] == '*') {
                    cur[j]='*';
                    lastEmpty = j - 1;
                }
                while (lastEmpty>=0&&(cur[lastEmpty] == '#' || cur[lastEmpty] == '*')) {
                    lastEmpty--;
                }
            }
            for(int j=0;j<n;j++) {
                if(cur[j]==' ' ){
                    res[j][m-i-1]='.';
                }else {
                    res[j][m - i - 1] = cur[j];
                }
            }
        }
        return res;
    }
}
