package com.leetcode;

import java.util.Arrays;

public class leetcode5885 {
    public int minMovesToSeat(int[] seats, int[] students) {
        int res=0;
        Arrays.sort(students);
        Arrays.sort(seats);
        for (int i=0;i < seats.length;i++){
            res+=Math.abs(students[i]-seats[i]);
        }
        return res;
    }
}
