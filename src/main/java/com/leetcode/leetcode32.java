package com.leetcode;

import java.util.Stack;

public class leetcode32 {
    //左取决于右，目前匹配就扔掉，匹配一个扔一个，长度+2
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()&&s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.clear();
                    stack.push(i);
                }
            }
            if(stack.isEmpty()){
                res=Math.max(res,i+1);
            }else {
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
