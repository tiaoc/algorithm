package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class a {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            Arrays.sort(nums);
            int sum=0;
            for(int i=n-1;i>=0;i--){
                sum+=nums[i];
            }
            int res=0;
            for(int i=n-1;i>0;i--){
                res+=sum;
                sum-=nums[i];
            }
            System.out.println(res);
        }
}
