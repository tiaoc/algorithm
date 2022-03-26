package com.leetcode;

import java.util.Arrays;

public class leetcode5964 {
    // 相对偏移量和当前位置不同，结果是否越界，前缀和
    public static void main(String[] args) {
        int[] st = new int[]{0, 1};
        System.out.println(Arrays.toString(new leetcode5964().executeInstructions(3, st, "RRDDLU")));
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[][] move = new int[s.length() + 1][2];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'L':
                    move[i + 1][1] = move[i][1] - 1;
                    move[i + 1][0] = move[i][0];
                    break;
                case 'R':
                    move[i + 1][1] = move[i][1] + 1;
                    move[i + 1][0] = move[i][0];
                    break;
                case 'U':
                    move[i + 1][0] = move[i][0] - 1;
                    move[i + 1][1] = move[i][1];
                    break;
                case 'D':
                    move[i + 1][0] = move[i][0] + 1;
                    move[i + 1][1] = move[i][1];
                    break;
                default:
            }
        }
        int[] res = new int[s.length()];
        int[] curPos = new int[2];
        for (int i = 1; i < move.length; i++) {
            curPos[0] = startPos[0] ;
            curPos[1] = startPos[1] ;
            int count = move.length - i;
            for (int j = i; j < move.length; j++) {
                if (curPos[0] + move[j][0]- move[i-1][0] < 0 || curPos[0] + move[j][0]- move[i-1][0] >= n ||
                        curPos[1] + move[j][1]- move[i-1][1] < 0 || curPos[1] + move[j][1] - move[i-1][1]>= n) {
                    count = j - i;
                    break;
                }
            }
            res[i - 1] = count;
        }
        return res;
    }
}
