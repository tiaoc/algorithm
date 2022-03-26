package com.toOffer01;


import java.util.Arrays;

public class code21 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
    public static int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j) {
            if ((nums[i] & 1) == 1) {
                i++;
                continue;
            }
            if ((nums[j] & 1) == 0){
                j--;
                continue;
            }
            swap(nums,i++,j--);
        }
        return nums;
    }
    public static void swap(int[] nums,int i,int j){
        int temp;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
