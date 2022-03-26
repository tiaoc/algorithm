package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if(person1[0]!=person2[0]){
                //由高到低排
                return person2[0]-person1[0];
            }else{
                return person1[1]-person2[1];
            }
        });
        LinkedList<int[]> list=new LinkedList<>();
        for(int[] person :people){
            list.add(person[1],person);
        }
        return list.toArray(people);
    }
}
