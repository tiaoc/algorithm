package com.toOffer01;

import java.util.Arrays;

public class code03 {
    public static void main(String[] args) {
        int[] numbers={2, 3, 1, 0, 2, 5, 3};
        int[] dup=new int[1];
        Solution s=new Solution();
        System.out.println(s.duplicate(numbers,6,dup));
    }
    public static class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        Solution(){}
        public int duplicate(int[] numbers, int length, int [] duplication) {
            for(int i=0;i<numbers.length;i++){
                while(numbers[i]!=i){
                    System.out.println(i);
                    System.out.println(Arrays.toString(numbers));
                    if(numbers[numbers[i]]== numbers[i]) return numbers[i];
                    int temp=numbers[i];
                    numbers[i]=numbers[temp];
                    numbers[temp]=temp;
                }
            }
            return -1;
        }
    }
}
