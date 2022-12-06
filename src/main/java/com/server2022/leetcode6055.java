package com.server2022;

public class leetcode6055 {
    public static void main(String[] args) {
        System.out.println(convertTime("09:41","10:34"));
    }
    public static int convertTime(String current, String correct) {
        String[] cur = current.split(":");
        String[] tar = correct.split(":");
        int h = (Integer.parseInt(tar[0]) - Integer.parseInt(cur[0]) + 24) % 24;
        int m = Integer.parseInt(tar[1]) - Integer.parseInt(cur[1]);
        int dif = h * 60 + m;
        if (dif < 0) {
            dif = 60 + dif;
        }
        int[] arr = new int[]{60, 15, 5, 1};
        int count = 0;
        for (int j : arr) {
            count += dif / j;
            dif %= j;
        }
        return count;
    }
}
