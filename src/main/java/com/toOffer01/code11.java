package com.toOffer01;

public class code11 {
    public static void main(String[] args) {
        int[] test={3,5,1};
        System.out.println(minArray(test));
    }
//旋转数组的最小数字
    public static int minArray(int[] array) {
        int i=0,j=array.length-1;
        while(i<j) {
            int m = (i + j) / 2;
            if (array[m] > array[j]) {
                i = m + 1;
            } else if (array[m] < array[j]) {
                j = m;
            } else j--;
        }
        return array[i];
    }
}
/* 该题减治的思想是：通过排除不可能是最小值元素，进而缩小范围。当我们拿中间的数和最右边的数相比时，有三种情况：
1. 中间的数比右边的大，那么中间数不可能是最小的数，最小的数只可能出现在中间数的后面，改left = mid + 1缩小区间
2. 中间的数和右边的小，那么右边的数不可能是中位数，此时，中间的数可能是最小的数，改right = end 缩小区间
3. 中间的数和右边相等，例如[3,3,3,1,3]此时中间的数和最右边的数都为3，可以知道的是，此时我们可以排除最右边的数，改区间为right = right - 1
*/
