package com.leetcode;

public class leetcode5886 {
    //连续3个，最短1个或2个
    public boolean winnerOfGame(String colors) {
        int count = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count > 0;
    }
}
