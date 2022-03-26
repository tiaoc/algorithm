package com.leetcode;

public class leetcode5963 {
    public boolean isSameAfterReversals(int num) {
        if (num %10 ==0 && num!=0){
            return false;
        }
        return true;
    }
}
