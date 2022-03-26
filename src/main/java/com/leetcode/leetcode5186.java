package com.leetcode;

import java.util.ArrayList;

public class leetcode5186 {
    static class RangeFreqQuery {
        //前缀和
        ArrayList<ArrayList<Integer>> pre = new ArrayList<>(10001);

        public RangeFreqQuery(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < 10001; i++) {
                pre.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                pre.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            ArrayList<Integer> cur = pre.get(value);
            if(cur.size()==0){
                return 0;
            }
            int l = 0, r = cur.size()-1;
            if (left > cur.get(cur.size() - 1))
                return 0;
            if (right < cur.get(0))
                return 0;
            while (l <= r) {
                int mid=(l+r)/2;
                if(cur.get(mid)<left){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            int ll=r;
            l = 0; r = cur.size()-1;
            while (l <= r) {
                int mid=(l+r)/2;
                if(cur.get(mid)<=right){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            int rr=r;
            return rr-ll;
        }
    }
}
