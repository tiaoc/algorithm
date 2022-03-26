package com.leetcode;

public class leetcode1185 {
    //平润，开始日期。
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        day += (year - 1971) * 365 + (year - 1969) / 4;
        for (int i = 0; i < month - 1; ++i) {
            day += months[i];
        }
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) && month >= 3) {
            ++day;
        }
        return week[(day + 3) % 7];
    }
}
