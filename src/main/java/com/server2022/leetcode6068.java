package com.server2022;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode6068 {
    public static void main(String[] args) {
        int[][] tiles = new int[][]{{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}};
        int[][] tile = new int[][]{{10, 11}, {1, 1}};
        int[][] t = new int[][]{{8051, 8057}, {8074, 8089}, {7994, 7995}, {7969, 7987}, {8013, 8020}, {8123, 8139}, {7930, 7950}, {8096, 8104}, {7917, 7925}, {8027, 8035}, {8003, 8011}};
        System.out.println(maximumWhiteTiles(tiles, 10));
    }

    //遍历左边不为空的窗口
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(t -> t[0]));
        int n = tiles.length, left = 0, right = 0, sum = 0, max = 0;
        while (left <= right && right < n) {
            int leftBoundary = tiles[left][0], rightBoundary = leftBoundary + carpetLen - 1;
            if (tiles[right][1] <= rightBoundary) {
                sum += tiles[right][1] - tiles[right][0] + 1;
                right++;
                max = Math.max(sum, max);
            } else {
                if (rightBoundary >= tiles[right][0]) {
                    max = Math.max(max, sum + rightBoundary - tiles[right][0] + 1);
                }
                sum -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
        }
        return max;
    }
}
