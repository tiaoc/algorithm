package com.leetcode;

import java.util.*;

public class leetcode5864 {
    public static void main(String[] args) {
        int[][] properties = {{10, 1}, {5, 1}, {7, 10}, {4, 1}, {5, 9}, {6, 9}, {7, 2}, {1, 10}};
        System.out.println(new leetcode5864().numberOfWeakCharacters(properties));
    }

    //一个集合放攻高的另一个放血高的，取交集。单调栈找到下一个严格大的，储存中间的，但严格大于中间的数，
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, ((a, b) -> {
            if (b[0] == a[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        }));
        int count = 0;
        int maxDef = 0;
        for (int i = 0; i < properties.length; i++) {
            if (maxDef > properties[i][1]) {
                System.out.println(Arrays.toString(properties[i]));
                count++;
            }
            maxDef = Math.max(maxDef, properties[i][1]);
        }
        return count;
    }
}