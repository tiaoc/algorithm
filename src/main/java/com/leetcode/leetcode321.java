package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class leetcode321 {
    public static void main(String[] args) {
        int[]nums1=new int[]{6,7};
        int[]nums2=new int[]{6,0,4};
        int k=5;
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, k)));
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res=new int[k];
        for(int i=Math.max(0,k-nums2.length);i<=k&&i<=nums1.length;i++){
            int[] temp=merge(maxSub(nums1,i),maxSub(nums2,k-i),k);
            if(compare(temp,0,res,0)){
                res=temp;
            }
        }
        return res;
    }
    private static int[] maxSub(int[] nums,int k){
        int remove=nums.length-k;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&stack.peek()<nums[i]&&remove>0){
                stack.pop();
                remove--;
            }
            stack.push(nums[i]);
        }
        int[] res=new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            res[i]=stack.get(i);
        }
        return res;
    }
    private static int[] merge(int[]nums1,int[] nums2,int k){
        int i=0,j=0;
        int [] res= new int[k];
        for(int m=0;m<k;m++){
            if(compare(nums1,i,nums2,j)){
                res[m]=nums1[i++];
            }else {
                res[m]=nums2[j++];
            }
        }
        return res;
    }
    private static boolean compare(int[] nums1,int index1, int[] nums2,int index2){
        int x=nums1.length,y=nums2.length;
        while(index1<x&&index2<y){
            int diff=nums1[index1]-nums2[index2];
            if(diff>0){
                return true;
            }else if( diff<0){
                return false;
            }
            index1++;
            index2++;
        }
        if(x-index1>y-index2){
            return true;
        }else {
            return false;
        }
    }
}
