package com.leetcode;

import java.util.Map;

public class leetcode6028 {
    public int countCollisions(String directions) {
        int sum = 0, collisions = 0;
        boolean leftFlag = true;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'R') {
                if (sum >= 0) {
                    sum++;
                } else {
                    sum = 1;
                }
            } else if (directions.charAt(i) == 'L') {
                if (sum <= 0) {
                    if (!leftFlag) {
                        collisions += -1 * sum + 1;
                    }
                    sum = 0;
                } else {
                    collisions += sum + 1;
                    leftFlag = false;
                    sum = 0;
                }
            } else {
                collisions += Math.abs(sum);
                leftFlag = false;
                sum = 0;
            }
        }
        return collisions;
    }
}
