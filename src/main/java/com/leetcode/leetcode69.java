package com.leetcode;

public class leetcode69 {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x / 2;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (x / mid < mid) {
                // mid 要变小，取左边区间, right = mid
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode69().mySqrt2(8));
    }
    public int mySqrt2(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x/2 + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid ==mid) {
                return mid;
            }else{
                // mid 要变小，取左边区间, right = mid
                right = mid;
            }
        }
        //left = mid+1后，left=right，输出结果，由于mid向下取整，最后输出的mid+1是找到的右边界。
        // 1,2,3的情况，left=mid+1=3，
        return left - 1;
    }
}
