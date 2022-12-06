package com.server2022;

public class leetcode6038 {
    public static void main(String[] args) {
        System.out.println(new leetcode6038().minimizeResult("12+34"));
    }

    public String minimizeResult(String expression) {
        int addPos = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                addPos = i;
                break;
            }
        }
        Entry res = new Entry(Integer.MAX_VALUE, 0, 0);
        for (int i = 0; i < addPos; i++) {
            Entry t = dfs(i, addPos, expression);
            if (t.value < res.value) {
                res = t;
            }
        }
        StringBuilder ret = new StringBuilder(expression);
        ret.insert(res.left, '(');
        ret.insert(res.right + 1, ')');
        return ret.toString();
    }

    private Entry dfs(int leftP, int addPos, String exp) {
        Entry e = new Entry(Integer.MAX_VALUE, 0, 0);
        for (int i = addPos + 2; i <= exp.length(); i++) {
            int tmp = compute(leftP, i, addPos, exp);
            if (tmp < e.value) {
                e = new Entry(tmp, leftP, i);
            }
        }
        return e;
    }

    private static int compute(int leftP, int rightP, int addPos, String exp) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < leftP; i++) {
            a = a * 10 + exp.charAt(i) - '0';
        }
        if (leftP == 0) {
            a = 1;
        }
        for (int i = leftP; i < addPos; i++) {
            b = b * 10 + exp.charAt(i) - '0';
        }
        for (int i = addPos + 1; i < rightP; i++) {
            c = c * 10 + exp.charAt(i) - '0';
        }
        for (int i = rightP; i < exp.length(); i++) {
            d = d * 10 + exp.charAt(i) - '0';
        }
        if (rightP == exp.length()) {
            d = 1;
        }
        return a * (b + c) * d;
    }

    private static class Entry {
        public int value;
        public int left;
        public int right;

        public Entry(int value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
