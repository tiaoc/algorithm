package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<rowIndex;i++){
            List<Integer> pre=new ArrayList<>(list);
            System.out.println(pre);
            list=new ArrayList<>();
            for(int j=0;j<pre.size();j++){
                if(j==0||j==pre.size()-1){
                    list.add(pre.get(j));
                }else{
                    list.add(pre.get(j-1)+pre.get(j));
                }
            }
        }
        return list;
    }
}
