package com.toOffer02;

public class code53 {
    public static void main(String[] args) {
        int[] nums = {5,7,8,8,10};
        System.out.println(search(nums,8));
        int[] num={2,2};
//        System.out.println(search(num,3));
    }
    public static int search(int[] nums, int target) {
        //end=start+1
        //对于target不存在于数组中的情况，使用<或<=对结果没有影响，使用start或者end也没有影响（end=start+1）
        //对于target存在于数组中2或多次的情况，使用
        // <,出来的start会在最左边，=的情况下，<不成立，会走到大于等于那边，使得end=m-1；将start往左回
        // <=,出来的start会在最右边，=的情况下，<=成立，使得start=m+1;将start往右推
        if(nums.length==0) return 0;
        int start=0;
        int end=nums.length-1,middle;
        while(start<=end){
            middle= (start+end)/2;
            if(nums[middle]<target){
                start=middle+1;
            }else {
                end=middle-1;
            }
        }
        int left=start;
        start=0;
        end=nums.length-1;
        while(start<=end){
            middle= (start+end)/2;
            if(nums[middle]<=target){
                start=middle+1;
            }else {
                end=middle-1;
            }
        }
        int right=start;
//        System.out.println(left);
//        System.out.println(right);
        return right-left;
    }
}
