package com.leetcode;

import java.util.Stack;

public class leetcode5840 {
    //两种情况，无非是左右互换。换哪里的左，换哪里的右
    //换最左边的右和最右边的左
    public int minSwaps(String s) {
        char[] sc=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        int idx=0;
        while(idx<s.length()){
            if(sc[idx]=='['){
                stack.push('[');
            }else if (!stack.isEmpty()) {
                stack.pop();
            }
            idx++;
        }
        int res= (int) Math.ceil((double) stack.size()/2);
        return res;
    }
}
