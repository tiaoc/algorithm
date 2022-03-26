package com.leetcode;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class leetcode88 {
    //时间复杂度o(m+n)，空间复杂度o（1）
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1,index2=n-1,index=m+n-1;
        while(index1>=0&&index2>=0){
            nums1[index--]=(nums1[index1]>nums2[index2])?nums1[index1--]:nums2[index2--];
        }
        System.arraycopy(nums2,0,nums1,0,index2+1);
    }
    //时间复杂度o(m+n)，空间复杂度o（m）
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        // Make a copy of nums1.
//        int [] nums1_copy = new int[m];
//        System.arraycopy(nums1, 0, nums1_copy, 0, m);
//
//        // Two get pointers for nums1_copy and nums2.
//        int p1 = 0;
//        int p2 = 0;
//
//        // Set pointer for nums1
//        int p = 0;
//
//        // Compare elements from nums1_copy and nums2
//        // and add the smallest one into nums1.
//        while ((p1 < m) && (p2 < n))
//            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
//
//        // if there are still elements to add
//        if (p1 < m)
//            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
//        if (p2 < n)
//            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
//    }
    //时间复杂度o（m+n），空间复杂度o（m+n）
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index1 = 0, index2 = 0,index=0, len = m+n;
//        int[] res = new int[len];
//        while(index<len){
//            if(index1<m&&index2<n) {
//                if (nums1[index1] < nums2[index2]) {
//                    res[index++] = nums1[index1++];
//                } else {
//                    res[index++] = nums2[index2++];
//                }
//            }else if(index1==m){
//                res[index++] = nums2[index2++];
//            }else {
//                res[index++] = nums1[index1++];
//            }
//        }
//        System.arraycopy(res,0,nums1,0,len);
//    }
}
