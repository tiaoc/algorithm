package com.leetcode;

import java.math.BigInteger;

//银行存款，M2，印钱
public class leetcode5903 {
    class Bank {
        BigInteger[] dep;
        public Bank(long[] balance) {
            dep =new BigInteger[balance.length];
            for (int i=0;i< balance.length;i++){
                dep[i]= BigInteger.valueOf(balance[i]);
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            --account1;
            --account2;
            if(account1<0||account1>=dep.length||account2<0||account2>=dep.length){
                return false;
            }
            if(dep[account1].compareTo(BigInteger.valueOf(money)) >= 0){
                dep[account1]=dep[account1].subtract(BigInteger.valueOf(money));
                dep[account2]=dep[account2].add(BigInteger.valueOf(money));
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            --account;
            if(account<0||account>=dep.length){
                return false;
            }
            dep[account]=dep[account].add(BigInteger.valueOf(money));
            return true;
        }

        public boolean withdraw(int account, long money) {
            --account;
            if(account<0||account>=dep.length){
                return false;
            }
            if(dep[account].compareTo(BigInteger.valueOf(money)) >= 0){
                dep[account]=dep[account].subtract(BigInteger.valueOf(money));
                return true;
            }
            return false;
        }
    }

}
