package com.toOffer01;


class code04{
    public static void main(String[] args) {
        int[] []array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,array));
        int[][] matrix={};
        System.out.println(Find(7,matrix));
    }
    public static boolean Find(int target, int[][] array) {
        if(array==null||array.length==0){
            return false;
        }
        int row=0;
        int col=array[0].length-1;
        while (row<array.length&&col>=0){
            if(array[row][col]>target){
                col--;
            }else if(array[row][col]<target){
                row++;
            }
            else return true;
        }
        return false;
    }

}
