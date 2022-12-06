package com.server2022;

public class leetcode6099 {
    //dp，前缀和？
    //有0记0，最大计
    //真实计数一直存在？，从每个字母往后都记
    // k和序列之间的关系，子字符串等于这个字符串，子字符串不是连续的，状态转移，每一位字符作为一个状态？状态就是在模板串中的顺序
    // 小于等于，0的数量尽可能大，往其中添加尽可能少的1.从后往前？
    // 1和0的数目没有限死，从后面拿1和0直到快拿爆
    //
    public int longestSubsequence(String s, int k) {
        char[] arr = s.toCharArray();
        int count = 0, num = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                count++;
            } else {
                if (count > 30) {
                    continue;
                }
                double c = Math.pow(2, count);
                if (num + c <= k) {
                    count++;
                    num += c;
                }
            }
        }
        return count;
    }
}
