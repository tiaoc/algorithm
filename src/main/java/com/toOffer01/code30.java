package com.toOffer01;

import java.util.Stack;

public class code30 {
    class MinStack {

        /** initialize your data structure here. */
            Stack<Integer> A,B;
        public MinStack() {
            A=new Stack<>();
            B=new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if(B.empty()||B.peek()>=x){
                B.add(x);
            }
        }

        public void pop() {
            if(B.peek().equals(A.pop()))
                B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}
