package com.leetcode;

public class leetcode5844 {
    /*做1出来
    * 连续的，隔着做1，连续的不能变，
    * 不能出0
    * 连续的如何变？
    * 集中1，集中0
    * 能搞出多少个1，搞出多少个2**p-1，2**p-2
    * 我不可能故意搞2**p-1出来，应该搞2**p-2
    * 因为1要留给快成0的数
    * 直接拿到总共1和0的数目
    * 最大数不能变2**p-1
    * 搞次大数2**p-2
    * 1-0-1
    * 2-2-4
    * 3-9-12
    * 没有全0但有全1，所以少p个0
    * 总共2**p-1个数
    * 16配对，不能成对存在16中间的数字
    * 能做出多少个16
    * 剩下的单个数不能控制大小
    * p个1，分给两个数
    * 互补
    * 两对互补，就能分成16
    * 多少个互补？
    * 2**p-1 单个
    * 2**p-2个对子
    * 202795991
    *
    * */
    public static void main(String[] args) {
        System.out.println(new leetcode5844().minNonZeroProduct(3));
        System.out.println(new leetcode5844().minNonZeroProduct(30));
        System.out.println(new leetcode5844().minNonZeroProduct(31));
    }

    public static final int mod=1000000007;
    public int minNonZeroProduct(int p) {
        long max=1L<<p;
        long t=max/2-1;
        long res= ((max-1)%mod*ksm((max-2)%mod, t))%mod;
        return (int)res;
    }
    public long ksm(long base,long N){
        long stage=base,res=1;
        while(N>0){
            if(N%2==1){
                res=res*stage%mod;
            }
            N/=2;
            stage=stage*stage%mod;
        }
        return res;
    }
}
