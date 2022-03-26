package com.somehistory;

import java.util.Arrays;
import java.util.Scanner;

public class vivo01 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int len=in.nextInt();
        int[] nums=new int[len];
        for(int i=0;i<len;i++){
            nums[i]=in.nextInt();
        }
        System.out.println(func(nums));
    }
    private static int func(int[]nums){
        if(nums.length<=2) return 1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(i+2<nums.length) {
                    count += func(Arrays.copyOfRange(nums, i + 2, nums.length));
                }
            }else{
                if(i+2<nums.length) {
                    count += func(Arrays.copyOfRange(nums, i + 1, nums.length));
                }
            }
        }
        return count;
    }
}
