package com.server2023;

import com.base.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode6939 {
    public ListNode doubleIt(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        List<ListNode> arr = new ArrayList<>();
        int add = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int v = list.get(i);
            int r = v * 2 + add;
            if (r >= 10) {
                r -= 10;
                add = 1;
            } else {
                add = 0;
            }
            if (arr.size() > 0) {
                arr.add(new ListNode(r, arr.get(arr.size() - 1)));
            } else {
                arr.add(new ListNode(r));
            }
        }
        if (add == 1) {
            arr.add(new ListNode(1, arr.get(arr.size() - 1)));
        }
        return arr.get(arr.size() - 1);
    }

    public int maxSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int v = num;
            int max = 0;
            while (v > 0) {
                int n = v % 10;
                v /= 10;
                max = Math.max(max, n);
            }
            if (map.containsKey(max)) {
                res = Math.max(res, map.get(max) + num);
                map.put(max, Math.max(map.get(max), num));
            } else {
                map.put(max, num);
            }
        }
        return res;
    }
}
