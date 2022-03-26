package com.toOffer02;

public class code43 {
    public int countDigitOne(int n) {
        return dfs(n);
    }
    private static int dfs(int n){
        if(n<=0) return 0;
        String str=String.valueOf(n);
        int high=str.charAt(0)-'0';
        int pow=(int)Math.pow(10,str.length()-1);
        int last=n-high*pow;
        if(high==1){
            return dfs(pow-1)+dfs(last)+last+1;
            //1120
            //dfs（pow-1） 一个0-999
            //余位（120）中含多少个1
            //last+1 1000-120 有121个数，即last+1
        }else {
            return high*dfs(pow-1)+pow+dfs(last);
            //5120
            //pow 1000-1999 最高位含1的数有pow个
            //high*dfs（pow-1） 有high个0-999
            //dfs（last） 余位（120）中含多少个1
        }
    }
}
