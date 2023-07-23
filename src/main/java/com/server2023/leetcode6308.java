package com.server2023;

import com.base.TreeNode;

import java.util.*;

public class leetcode6308 {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1000000007;
        int[][] dp = new int[types.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= types.length; i++) {
            int[] type = types[i - 1];
            int num = type[0], value = type[1];
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= num && k * value <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * value]) % mod;
                }
            }
        }
        return dp[types.length][target];
    }

    /**
     * 和正解只差一个变量，我痛心啊！
     * @param nums
     * @return
     */
    public int findValidSplit(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int b = i;
            for (int j = nums.length - 1; j >= m; j--) {
                if (gcd(nums[i], nums[j]) != 1) {
                    b = j;
                    break;
                }
            }
            m = Math.max(b, m);
            if (m <= i) {
                return i;
            }
        }
        return -1;
    }

    // 乘积就是与其中每一个，都互质，左边每个数和右边每个数，互质，找每个数的互质组（非互质组）
    // 左边每个数的的非互质数都不在右边，每个数的非互质数的右边界。
    public int findValidSplit2(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int b = i;
            for (int j = nums.length - 1; j >= i + 1; j--) {
                if (gcd(nums[i], nums[j]) != 1) {
                    b = j;
                    break;
                }
            }
            m = Math.max(b, m);
            if (m <= i) {
                return i;
            }
        }
        return -1;
    }

    private int gcd(int m, int n) {
        while (n > 0) {
            int t = m % n;
            m = n;
            n = t;
        }
        return m;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Long> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            long v = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                v += cur.val;
                if (cur.left != null) {
                    next.offer(cur.left);
                }
                if (cur.right != null) {
                    next.offer(cur.right);
                }
            }
            queue = next;
            res.add(v);
        }
        if (res.size() < k) {
            return -1;
        }
        res.sort(Comparator.comparingLong(a -> a));
        return res.get(res.size() - k);
    }


    public int passThePillow(int n, int time) {
        int pos = 1;
        boolean order = true;
        for (int i = 0; i < time; i++) {
            if (order) {
                if (pos < n) {
                    pos++;
                } else {
                    order = false;
                    pos--;
                }
            } else {
                if (pos > 1) {
                    pos--;
                } else {
                    order = true;
                    pos++;
                }
            }
        }
        return pos;
    }
}
