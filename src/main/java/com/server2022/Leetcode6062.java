package com.server2022;

public class Leetcode6062 {
    class ATM {
        private final long[] money;

        public ATM() {
            money = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                this.money[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] tempOut = new int[5];
            if (amount < 20) {
                return new int[]{-1};
            }
            while (amount > 0) {
                if (amount >= 500 && money[4] > 0) {
                    if(amount>=money[4]*500){
                        amount -= money[4]*500;
                        tempOut[4]=(int)money[4];
                        money[4]=0;
                    }else {
                        tempOut[4]=amount/500;
                        money[4]-=amount/500;
                        amount%=500;
                    }
                } else if (amount >= 200 && money[3] > 0) {
                    if(amount>=money[3]*200){
                        amount -= money[3]*200;
                        tempOut[3]=(int)money[3];
                        money[3]=0;
                    }else {
                        tempOut[3]=amount/200;
                        money[3]-=amount/200;
                        amount%=200;
                    }
                } else if (amount >= 100 && money[2] > 0) {
                    if(amount>=money[2]*100){
                        amount -= money[2]*100;
                        tempOut[2]=(int)money[2];
                        money[2]=0;
                    }else {
                        tempOut[2]=amount/100;
                        money[2]-=amount/100;
                        amount%=100;
                    }
                } else if (amount >= 50 && money[1] > 0) {
                    if(amount>=money[1]*50){
                        amount -= money[1]*50;
                        tempOut[1]=(int)money[1];
                        money[1]=0;
                    }else {
                        tempOut[1]=amount/50;
                        money[1]-=amount/50;
                        amount%=50;
                    }
                } else if (amount >= 20 && money[0] > 0) {
                    if(amount>=money[0]*20){
                        amount -= money[0]*20;
                        tempOut[0]=(int)money[0];
                        money[0]=0;
                    }else {
                        tempOut[0]=amount/20;
                        money[0]-=amount/20;
                        amount%=20;
                    }
                } else {
                    returnMoney(money, tempOut);
                    return new int[]{-1};
                }
            }
            return tempOut;
        }

        public void returnMoney(long[] money, int[] tempOut) {
            for (int i = 0; i < 5; i++) {
                money[i] += tempOut[i];
            }
        }
    }

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
}
