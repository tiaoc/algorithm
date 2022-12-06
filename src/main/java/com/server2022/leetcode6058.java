package com.server2022;

public class leetcode6058 {
    // 连续个x，有多种解释，可能是多个字母1，一个字母n，多个字母xxx组合，考虑连续多少个x有多少种组合
    // 1
    // 11 2
    // 111 12 21 3
    // 1111 112 121 13,1111 121 211 31   +   1111 22  有序地合并
    // 某一位，前面的变化和后面的变化
    public static void main(String[] args) {
        System.out.println(new leetcode6058().countTexts("22233"));
    }

    public int countTexts(String pressedKeys) {
        int mod = 1000000007;
        int cur = 0, count = 0;
        long pos = 1;
        int[][] arr = computeChange(100000, mod);
        for (int i = 0; i < pressedKeys.length(); i++) {
            if (cur != pressedKeys.charAt(i) - '0') {
                int v = arr[0][count];
                if (cur == 7 || cur == 9) {
                    v = arr[1][count];
                }
                pos = (pos * v) % mod;
                count = 0;
                cur = pressedKeys.charAt(i) - '0';
            }
            count++;
        }
        int v = arr[0][count];
        if (cur == 7 || cur == 9) {
            v = arr[1][count];
        }
        pos = (pos * v) % mod;
        return (int) pos;
    }

    public int[][] computeChange(int count, int mod) {
        int[] map3 = new int[count + 1];
        int[] map4 = new int[count + 1];
        map3[0] = 1;
        map3[1] = 1;
        for (int i = 2; i <= count; i++) {
            for (int j = 0; j <= 3 && j <= i; j++) {
                map3[i] = (map3[i] + map3[i - j] % mod) % mod;
            }
        }
        map4[0] = 1;
        map4[1] = 1;
        for (int i = 2; i <= count; i++) {
            for (int j = 0; j <= 4 && j <= i; j++) {
                map4[i] = (map4[i] + map4[i - j] % mod) % mod;
            }
        }
        return new int[][]{map3, map4};
    }
}
