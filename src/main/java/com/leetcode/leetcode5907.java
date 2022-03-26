package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode5907 {
    //3要出现3次，4要出现4次，不能算0，1111中，0的出现次数是0，但还是不能算做结果，所以不能算0的0次
    //出现1个1，出现2个2，出现3个3，平衡数实际上是由位数决定的，x位，则平衡数最大可以是x+1。
    //如果要提升一位的话，那么平衡数只能是1022的的形式，那么平衡值最大就是x。
    //4333，1333，2333，3133，3313，3323，3343
    //求组合中最小的大于给定值的数
    //1022 2001 3001 4001
    //1  2 2  3 3 3  4 4 4 4
    //1 --21
    //每个数位d，都出现d次，数字肯定不含0
    //122333 4444 22333
    //数字不会出现5
    //只能由1234构成，1个1 2个2 3个3 4个4 5个5
    //4-----1个1，3个3
    //5-----2个2，3个3   1个1，4个4
    public static void main(String[] args) {
        System.out.println(new leetcode5907().nextBeautifulNumber(10461));
    }

    List<String> res=new ArrayList<>();
    public int nextBeautifulNumber(int n) {
        if(n==0){
            return 1;
        }
        if(n<22){
            return 22;
        }
        if(n<1000){
            int[][] arr=new int[2][];
            arr[0]=new int[]{1,2,2};
            arr[1]=new int[]{3,3,3};
            return find(arr,n,1333);
        }
        if(n<10000){
            int[][] arr=new int[2][];
            arr[0]=new int[]{1,3,3,3};
            arr[1]=new int[]{4,4,4,4};
            return find(arr,n,144444);
        }
        if(n<100000){
            int[][] arr=new int[3][];
            arr[0]=new int[]{2,2,3,3,3};
            arr[1]=new int[]{1,4,4,4,4};
            arr[2]=new int[]{5,5,5,5,5};
            return find(arr,n,122333);
        }
        int[][] arr=new int[4][];
        arr[0]=new int[]{2,2,4,4,4,4};
        arr[1]=new int[]{1,2,2,3,3,3};
        arr[2]=new int[]{1,5,5,5,5,5};
        arr[3]=new int[]{6,6,6,6,6,6};
        return find(arr,n,1224444);
    }
    private int find(int[][] arr,int n,int max){
        for (int [] nums : arr){
            dfs(new StringBuilder(),nums,new boolean[nums.length]);
        }
        int[] aa=new int[res.size()];
        for(int i=0;i<res.size();i++){
            aa[i]=Integer.parseInt(res.get(i));
        }
        Arrays.sort(aa);
        for (int value : aa) {
            if (value > n) {
                return value;
            }
        }
        return max;
    }
    private void dfs(StringBuilder sb,int[]nums,boolean[] visited){
        if(sb.length()==nums.length){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                sb.append(nums[i]);
                dfs(sb,nums,visited);
                visited[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
