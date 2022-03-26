package com.toOffer02;

public class code39 {
    public int majorityElement(int[] nums) {
        int middle=nums.length>>1;//middle=length/2，索引是length/2的数（左边小于等于它右边大于等于它）是中位数
        int start=0;
        int end=nums.length-1;
        int index=partition(nums,start,end);//index左边的小于index，右边大于index
        while(index!=middle){
            if(index<middle){//index小于middle，则在index+1,end上继续搜索middle
                start=index+1;
            }else{//index大于middle，则在start，index-1上继续搜索middle
                end=index-1;
            }
            index=partition(nums,start,end);
        }
        return nums[middle];
    }
    private static int partition(int[] array,int start,int end){
        int pivot=array[end];
        while(start<end){
            while(start<end&&array[start]< pivot){
                start++;
            }
            if(start<end){
                array[end--]=array[start];
            }
            while(start<end&&array[end]>pivot){
                end--;
            }
            if(start<end){
                array[start++]=array[end];
            }
        }
        array[start]=pivot;//start的值已经赋给end
        return start;
    }
}
