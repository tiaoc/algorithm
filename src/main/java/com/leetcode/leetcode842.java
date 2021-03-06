package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode842 {
    public static void main(String[] args) {
        String str="0123";
        System.out.println(splitIntoFibonacci(str));
    }
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list=new ArrayList<>();
        backtrack(list,S,S.length(),0,0,0);
        return list;
    }
    public static boolean backtrack(List<Integer> list,String S,int length,int index,int sum,int prev){
        if(index==length){
            return list.size()>=3;
        }
        long currLong=0;
        for(int i=index;i<length;i++){
            if(i>index&&S.charAt(index)=='0'){
                break;
            }
            currLong=currLong*10+S.charAt(i)-'0';
            if(currLong>Integer.MAX_VALUE){
                break;
            }
            int curr=(int) currLong;
            if(list.size()>=2){
                if(curr<sum){
                    continue;
                }else if(curr>sum){
                    break;
                }
            }
            list.add(curr);
            if(backtrack(list,S,length,i+1,prev+curr,curr)){
                return true;
            }else{
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
