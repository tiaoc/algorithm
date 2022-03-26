package com.leetcode;

import java.util.Stack;

public class leetcode84 {
    //左右 上下限制
    //木桶效应，根据最低的做高度，左右变化调整高度，线性改变宽度，不定改变高度。
    //栈，留下最小值
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i]=0;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;--i){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i]=n-1;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max((right[i]-left[i]+1)*heights[i],res);
        }
        return res;
    }
}
