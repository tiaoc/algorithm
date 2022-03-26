package com.toOffer01;

import java.util.Stack;

public class code09 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(stack1.empty()&&stack2.empty()) return -1;
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
/*  原来的方法
    public void appendTail(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }

    }

    public int deleteHead() {
        if (!stack2.empty()){
            return stack2.pop();
        }else{
            return -1;
        }
    }*/

}
