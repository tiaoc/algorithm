package com.leetcode;

public class leetcode5690 {
    int res;

    public static void main(String[] args) {
        int[]baseCosts={3,10};
        int []toppingCosts={2,5};
        leetcode5690 l=new leetcode5690();
        System.out.println(l.closestCost(baseCosts,toppingCosts,9));
    }
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = baseCosts[0];
        for (int base : baseCosts) {
            if (Math.abs(target - base) < Math.abs(target - res) || Math.abs(target - base) == Math.abs(target - res) && base < res) {
                res = base;
            }
            dfs(0, base, target, toppingCosts);
        }
        return res;
    }

    private void dfs(int cur, int cost, int target, int[] toppingCosts) {
        for (int i = cur; i < toppingCosts.length; i++) {
            if ((Math.abs(target - (cost + toppingCosts[i]))) < Math.abs(target - res) || Math.abs(target - (cost + toppingCosts[i])) == Math.abs(target - res) && (cost + toppingCosts[i] < res)) {
                res = cost + toppingCosts[cur];
                System.out.println(res);
            }
            if ((Math.abs(target - (cost + 2 * toppingCosts[i]))) < Math.abs(target - res) || Math.abs(target - (cost + 2 * toppingCosts[i])) == Math.abs(target - res) && (cost + 2 * toppingCosts[i] < res)) {
                res = cost + 2 * toppingCosts[cur];
            }
            dfs(i + 1, cost + toppingCosts[i], target, toppingCosts);
            dfs(i + 1, cost + 2 * toppingCosts[i], target, toppingCosts);
        }
    }
}
