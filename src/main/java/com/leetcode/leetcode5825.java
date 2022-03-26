package com.leetcode;

public class leetcode5825 {
    //如何匹配，相同匹配程度如何分配？
    //dp？学生和老师都是x。
    //dfs bfs
    //一个集合和另一个集合匹配
    //贪心，不行，没有考虑后效性
    //在当前选择选择最优解。次优...
    //寻找不匹配数
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m=students.length,n=students[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(students[i][k]==mentors[i][k]){

                    }
                }
            }
        }
        return 0;
    }
}
