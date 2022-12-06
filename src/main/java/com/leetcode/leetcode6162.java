package com.leetcode;

public class leetcode6162 {
    public static void main(String[] args) {
        String[] s = new String[]{"G", "P", "GP", "GG"};
        int[] n = new int[]{2, 4, 3};
        System.out.println(new leetcode6162().garbageCollection(s, n));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[][] gbs = new int[garbage.length][3];
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                switch (garbage[i].charAt(j)) {
                    case 'M':
                        gbs[i][0]++;
                        break;
                    case 'P':
                        gbs[i][1]++;
                        break;
                    case 'G':
                        gbs[i][2]++;
                }
            }
        }
        int res = 0;
        for (int p = 0; p < 3; p++) {
            int time = 0;
            int pos = 0;
            for (int i = 0; i < garbage.length; i++) {
                if (gbs[i][p] > 0) {
                    int gap = 0;
                    for (int j = pos; j < i; j++) {
                        gap += travel[j];
                    }
                    time += gap + gbs[i][p];
                    pos = i;
                }
            }
            res += time;
        }
        return res;
    }
}
