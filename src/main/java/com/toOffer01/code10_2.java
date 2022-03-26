package com.toOffer01;

public class code10_2 {
    //青蛙跳台阶
    public static void main(String[] args) {
        System.out.println(numWays(44));
    }

    public static int numWays(int target) {
        int[] ff = {1, 2};
        int temp;
        for (int i = 1; i < target; i++) {
            temp = ff[1];
            ff[1] = ff[0] + ff[1];
            ff[1]=ff[1]%1000000007;
            ff[0] = temp;
        }
        if (target == 0) return 1;
        return ff[0];
    }

}
