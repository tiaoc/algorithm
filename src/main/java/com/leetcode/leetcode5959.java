package com.leetcode;

public class leetcode5959 {
    // 145333
    // 改动某一个数，这个数和它前面 后面的关系，这个地方改动与否取决于左右两边的改动难度
    // 找逆序，逆序元素改变，逆序个数也改变
    // 145333 1个逆序元素，改3，又1个逆序。5和3的关系
    // 1 2 5 3 1 3 3 3
    // 1 2 5 3 1 3 3 2
    // 1 2 2 3 1 3 2
    // 如果一个数字小于前且大于后 必改，前面能保证无错吗？后面能保证不改吗？
    //考虑原来的递增顺序 怎么做能接到原来的递增顺序
    public int kIncreasing(int[] arr, int k) {
        for (int i=0;i<k;i++){
            for (int j=i+k;j<arr.length;j+=k){

            }
        }
        return 0;
    }
}
