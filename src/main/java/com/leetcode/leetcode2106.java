package com.leetcode;

public class leetcode2106 {
    public static void main(String[] args) {
        System.out.println(new leetcode2106().maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}}, 5,4));
    }
    // 移动范围
    // 先向左移 start-x -- start+k-2*x
    // 先向右移 start-k+2*x -- start+x
    // x从0到k;向左右最多都是k，对应x为0.
    // 如何找移动范围？遍历每个情况，用前缀和减一下
    // 找到索引在的位置，二分找最近的值
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] prefix = new int[fruits.length + 1];
        int[] indices = new int[fruits.length];
        for (int i = 0; i < fruits.length; i++) {
            prefix[i + 1] = prefix[i] + fruits[i][1];
            indices[i] = fruits[i][0];
        }
        int res = 0;
        for (int i = 0; i <= k / 2; i++) {
            // 不能比left小
            int idxLeft = lowerBound(indices, startPos - i);
            // 不能比right大
            int idxRight = lowerBound(indices, startPos + k - 2 * i);
            res = Math.max(res, prefix[idxRight] - prefix[idxLeft]);
            idxLeft = lowerBound(indices, startPos - k + 2 * i);
            idxRight = lowerBound(indices, startPos + i);
            res = Math.max(res, prefix[idxRight] - prefix[idxLeft]);
        }
        return res;
    }

    public int lowerBound(int[] indices, int target) {
        int left = 0, right = indices.length - 1;
        int ans = indices.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (indices[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }

    public int upperBound(int[] indices, int target) {
        int left = 0, right = indices.length - 1;
        int ans = indices.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (indices[mid] <= target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }
}
