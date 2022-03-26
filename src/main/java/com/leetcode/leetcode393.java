package com.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class leetcode393 {
    public static final Logger logger = LoggerFactory.getLogger(leetcode393.class);
    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{145}));
        logger.info("393");
    }

    static final int mask1 = 1 << 7;
    static final int mask2 = (1 << 7) + (1 << 6);

    public static boolean validUtf8(int[] data) {
        return nextValue(data, 0);
    }

    public static boolean nextValue(int[] data, int cur) {
        if (cur == data.length) {
            return true;
        }
        if ((data[cur] & mask1) == 0) {
            return nextValue(data, cur + 1);
        }
        int len = 0;
        for (int i = 7; i >= 4; i--) {
            if ((data[cur] & (1 << i)) == (1 << i)) {
                len++;
            } else {
                break;
            }
        }
        if (len < 2 || cur + len > data.length || (data[cur] & (1 << (7 - len))) != 0) {
            return false;
        }
        for (int i = cur + 1; i < cur + len; i++) {
            if ((data[i] & mask2) != 128) {
                return false;
            }
        }
        return nextValue(data, cur + len);
    }
}
