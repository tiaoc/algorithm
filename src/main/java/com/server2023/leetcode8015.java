package com.server2023;

import java.util.*;

public class leetcode8015 {
    public int furthestDistanceFromOrigin(String moves) {
        int opt = 0;
        int l = 0, r = 0;
        for (char c : moves.toCharArray()) {
            if (c == '_') {
                opt++;
            } else if (c == 'L') {
                l++;
            } else {
                r++;
            }
        }
        return Math.abs(l - r) + opt;
    }

    // 数组长度是n，两两组合和不为target，
    // target = x, 1到小于等于x/2，添加，然后添加target， 考虑target = x/2
    public long minimumPossibleSum(int n, int target) {
        int mid = target / 2;
        long res = 0;
        for (int i = 1; i <= mid; i++) {
            res += i;
            if (i == n) {
                return res;
            }
        }
        for (int i = target; i < target + n - mid; i++) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode8015().minOperations(Arrays.asList(1, 32, 1, 2), 12));
    }

    // 无法得到，已经存在的和小于target
    // 大数拆小，二进制位。11001
    // 已经存在的 100100
    // 从当前数组满足最小的，再满足最小的。
    // 不需要位数满足，只需要和满足。
    public int minOperations(List<Integer> nums, int target) {
        int[] arr = new int[33];
        int res = 0;
        for (int v : nums) {
            int count = 0;
            while (v > 0) {
                v /= 2;
                count++;
            }
            arr[count]++;
        }
        int cur = target;
        int count = 0;
        while (cur > 0) {
            int num = cur % 2;
            cur = cur / 2;
            count++;
            if (num > 0) {
                if (arr[count] > 0) {
                    arr[count]--;
                } else {
                    int f = count + 1;
                    while (f < arr.length && arr[f] == 0) {
                        f++;
                    }
                    if (f == arr.length) {
                        return -1;
                    }
                    arr[f]--;
                    for (int i = count + 1; i < f; i++) {
                        arr[i] = 1;
                    }
                    res += f - count;
                }
            }
            if (arr[count] > 1) {
                arr[count + 1] += arr[count] / 2;
            }
        }
        return res;
    }
    // 计算机处理速度和软件发展速度的关系，计算机处理速度基本不是瓶颈。对人还是对物？物可以无限复杂？

    // 有向图，找最大的节点序号传递序列，x只能定向传递给y。所以是要选择起始点。
    // 只能传k次。
    // 一整个重复循环的序列
    // 1传2 2传1 0传1,就在12间传，这是出现了环。自己传自己也是环。
    // 开始在1 和开始在2可能完全不同。但k有限制。找到所有路径，再找k最大的。
    // 所有路径不需要从每个节点开始。
    // 路径都是环，在环中切割最大的节点组。
    // 通过visit数组判断是否进环，进环则退出。
    // 遍历剩下的节点
    // 多个起点进入同一个环。
    // 如果有visit，就把对应节点的后序列挂上去。（从该节点到该节点）。k过大，所以不能存真实序列，只能存循环假队列。
    // 进入环的位置，环的状态，map存。没进入环的，用序列存。
    //　发现是环后，遍历一次环存下来。
    // 把每个进环点的值存下来即可，不需要存序列，根据临时环序列算出除几余几就行。
    // 把遇到的每个点都存下来，下次遇到直接取。
    // visited过，未必直接在环里
    // 几步进环，环总值多少。进环几步
    // todo finish
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        long[] nums = new long[n];
        boolean[] visited = new boolean[n];
        // 还有几步进环
        Map<Integer, Integer> pace = new HashMap<>();
        for(int i=0;i<n;i++){
            if (visited[i]){
                continue;
            }
            visited[i]=true;
            List<Integer> tempList = new LinkedList<>();
            int next = receiver.get(i);
            while(true){
                tempList.add(next);
                if (!visited[next]){
                    next =receiver.get(next);
                }
            }
        }
        return 0;
    }
}
