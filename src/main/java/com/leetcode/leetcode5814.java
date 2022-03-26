package com.leetcode;

public class leetcode5814 {
//    每个台阶的影响
//    如果不能继续往上上，就从自己的最高台阶增加。
//    像是贪心，但一个数字一个数字增加复杂度应该不低
//    当cur+dist<next时，增加（next-cur）/dist个台阶，然后到达next
    //下一个最远到达的next，下一个最远能够到达的cur+dist，cur+dist<next
    //
    public int addRungs(int[] rungs, int dist) {
        int res=0,cur=0,curRung=0;
        while(cur<rungs[rungs.length-1]){
            if(cur+dist<rungs[curRung]){
                res+=(rungs[curRung]-1-cur)/dist;
                cur=rungs[curRung];
                curRung++;
            }else if(cur+dist==rungs[curRung]){
                cur=rungs[curRung];
                curRung++;
            }else {
                while(curRung<rungs.length&&rungs[curRung]<=cur+dist){
                    curRung++;
                }
                cur=rungs[curRung-1];
            }
        }
        return res;
    }
}
