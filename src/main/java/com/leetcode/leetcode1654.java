package com.leetcode;

import java.util.Arrays;

public class leetcode1654 {
    // 存到每个位置最少的跳跃次数，如何保证无后效性
    // 可以越过当前点再回去，那么从当前点出发不能保证是最优步数
    // 从后往前，能到达的点是固定的，从前往后，也只有一个点能回溯，但这个回溯的点只能来源于正序。
    // 那么某个点的最小操作次数，区分开往后跳1次，和一直正序。
    // 可以往后，再往前，再往后
    // 如果a>b, 最近只能到a-b, 2a-2b, 3a-3b 都可以到。
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        int n = forbidden.length;
//        int[][] dp = new int[n][2];
//        for(int i=1;i<n;i++){
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        // 0 一直往前(下一次可以往后)/上一次往前， 1上一次往后的。
//        // a<b a>b
//        for(int i=0;i<n;i++){
//            dp[i+a][0]=Math.min(dp[i][0]+1, dp[i+a][0]);
//            dp[i+a][0]=Math.min(dp[i+b][1]+1, dp[i+a][0]);
//            if(i>b){
//                dp[i-b][1]=Math.min(dp[i-b][1],dp[i][0]+1);
//                dp[i][0]
//            }
//        }
        //todo finish
        return 0;

    }
}
