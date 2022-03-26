package com.toOffer02;

import java.util.Stack;

public class code31 {
    public static void main(String[] args) {
        int[] pushed={5,4,3,2,1},popped={4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> A=new Stack<>();
        int i=0,j=0;
        while(i<pushed.length){
            A.push(pushed[i]);
            i++;
            while(A.peek()==popped[j]){
                A.pop();
                j++;
                if(A.empty()) break;
            }
        }
        if(A.empty()) return true;
        return false;
    }
}
