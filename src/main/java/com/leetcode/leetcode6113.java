package com.leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class leetcode6113 {
    class SmallestInfiniteSet {
        SortedSet<Integer> set;
        int continues;

        public SmallestInfiniteSet() {
            set = new TreeSet<>();
            continues = 1;
        }

        public int popSmallest() {
            if (!set.isEmpty()) {
                int v = set.first();
                set.remove(v);
                return v;
            }
            return continues++;
        }

        public void addBack(int num) {
            if (num < continues) {
                set.add(num);
            }
        }
    }
}
