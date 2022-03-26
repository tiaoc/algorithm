package com.leetcode;

public class leetcode5977 {
    public static void main(String[] args) {
        int[] n =new int[] {0,1,0,1,1,0,0};
        System.out.println(new leetcode5977().minSwaps(n));
    }
    //从x到y，填充空格，xy也不确定，xy中包含最多的1即可，xy长度是是1的个数，滑动窗口算1的数量
    //滑动窗口要考虑环形特性，从-t到n
    public int minSwaps(int[] nums) {
        int n=nums.length,m=0;
        for (int num : nums) {
            if (num == 1) {
                ++m;
            }
        }
        int cur=0;
        for(int i=-m+1;i<=0;i++) {
            cur+=nums[(i+n)%n];
        }
        int maxWeight=cur;
        for (int i=-m+1;i<=n-m;i++){
            cur-=nums[(i+n)%n];
            cur+=nums[(i+m+n)%n];
            maxWeight = Math.max(cur,maxWeight);
        }
        return m-maxWeight;
    }
}
