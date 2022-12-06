package com.leetcode;

public class leetcode6158 {
    public static void main(String[] args) {
        int[][] sh = new int[][]{{4, 8, 0}, {4, 4, 0}, {2, 4, 0}, {2, 4, 0}, {6, 7, 1}, {2, 2, 1}, {0, 2, 1}, {8, 8, 0}, {1, 3, 1}};
        System.out.println(new leetcode6158().shiftingLetters("xuwdbdqik", sh));
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n + 1];
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], dir = shift[2] == 0 ? -1 : 1;
            arr[start] += dir;
            arr[end + 1] -= dir;
        }
        char[] cs = s.toCharArray();
        int pos = 0;
        for (int i = 0; i < n; i++) {
            pos = (pos + arr[i]) % 26;
            cs[i] += pos;
            if (cs[i] > 'z') {
                cs[i] -= 26;
            } else if (cs[i] < 'a') {
                cs[i] += 26;
            }
        }
        return new String(cs);
    }
}
