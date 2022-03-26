package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode6016 {
    public List<String> cellsInRange(String s) {
        char colStart = s.charAt(0);
        char colEnd = s.charAt(3);
        char rowStart = s.charAt(1);
        char rowEnd = s.charAt(4);
        List<String> res = new ArrayList<>();
        for (char c = colStart; c <= colEnd; c++) {
            for (char num = rowStart; num <= rowEnd; num++) {
                res.add(String.format("%c%c", c, num));
            }
        }
        return res;
    }
}
