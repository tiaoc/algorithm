package com.server2023;


import java.util.*;

public class leetcode7004 {
    public static void main(String[] args) {
        System.out.println(new leetcode7004().maximizeTheProfit(10, Arrays.asList(
                Arrays.asList(0, 6, 5),
                Arrays.asList(2, 9, 4),
                Arrays.asList(0, 9, 2),
                Arrays.asList(3, 9, 3),
                Arrays.asList(1, 6, 10),
                Arrays.asList(0, 1, 3),
                Arrays.asList(3, 8, 9),
                Arrays.asList(4, 8, 3),
                Arrays.asList(2, 6, 5),
                Arrays.asList(0, 4, 6))));
    }

    // O(n) 复杂度，将offer分到位置级别再dp。
    public int maximizeTheProfit0(int n, List<List<Integer>> offers) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < offers.size(); i++) {
            List<Integer> offer = offers.get(i);
            groups.computeIfAbsent(offer.get(1), (k) -> new ArrayList<>());
            groups.get(offer.get(1)).add(i);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i];
            if (groups.containsKey(i)) {
                List<Integer> indice = groups.get(i);
                for (int end : indice) {
                    List<Integer> offer = offers.get(end);
                    int start = offer.get(0), gold = offer.get(2);
                    dp[i + 1] = Math.max(dp[i + 1], dp[start] + gold);
                }
            }
        }
        return dp[n];
    }

    // 要约重叠的区间怎么处理，会互相影响。dp
    // 从x到y， x之前的区间出现的最大数 怎么处理
    // 单调栈？
    // 二分？ 数从小到大，区间 x 到 y 的数不变，是取x的值。给数

    // 对indice dp，用二分找到start（向左追溯）的indice，用这个indice对应的值，就是之前出现的最大值
    // https://leetcode.cn/problems/maximize-the-profit-as-the-salesman/solutions/2396413/er-fen-dp-by-man-qian-shu-xiao-ming-8svr/
    public int maximizeTheProfit1(int n, List<List<Integer>> offers) {
        int[] dp = new int[offers.size() + 1];
        offers.sort(Comparator.comparingInt(a -> a.get(1)));
        for (int i = 0; i < offers.size(); i++) {
            List<Integer> offer = offers.get(i);
            int start = offer.get(0), end = offer.get(1), gold = offer.get(2);
            int left = 0, right = offers.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (offers.get(mid).get(1) < start) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[i + 1] = Math.max(dp[left] + gold, dp[i]);
        }
        return dp[offers.size()];
    }

    // 对indice dp，用树状数组维护前缀的极大值。
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        N = n + 5;
        a = new int[N];
        offers.sort(Comparator.comparingInt(a -> a.get(1)));
        int res = 0;
        for (List<Integer> offer : offers) {
            int start = offer.get(0) + 1, end = offer.get(1) + 1, gold = offer.get(2);
            int cur = query(start - 1) + gold;
            res = Math.max(res, cur);
            update(end, cur);
        }
        return res;
    }

    int N;
    int[] a;

    void update(int loc, int val) {
        for (; loc < N; loc += lowbit(loc)) {
            a[loc] = Math.max(a[loc], val);
        }
    }

    int lowbit(int x) {
        return x & -x;
    }

    int query(int loc) {
        int res = 0;
        for (; loc > 0; loc -= lowbit(loc)) {
            res = Math.max(res, a[loc]);
        }
        return res;
    }

    // 1 0 1 1 2 3 4 5 6 7 1
    // 同值窗口在移动
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int res = 1;
        for (int i = 0; i < n; i++) {
            int v = nums.get(i);
            if (map.containsKey(v)) {
                Queue<Integer> cur = map.get(v);
                while (!cur.isEmpty() && (i - cur.peek() - cur.size() > k)) {
                    cur.poll();
                }
                cur.offer(i);
                res = Math.max(res, cur.size());
            } else {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                map.put(v, queue);
            }
        }
        return res;
    }


    //求和不等于k
    // x, k-x, 只能存在一个
    // x = k-x,可以出现
    public int minimumSum(int n, int k) {
        int size = 0;
        int num = 1;
        int res = 0;
        while (size < n) {
            res += num;
            size++;
            num++;
            if (num == k / 2 + 1) {
                num = k;
            }
        }
        return res;
    }

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i).charAt(0));
        }
        return sb.toString().equals(s);
    }
}
