package com.leetcode;

import java.util.HashSet;

public class leetcode5919 {
    // on要想到dp和前缀和
    // 前有人 后有人 ，我属于哪个子字符串，有多少个子字符串包含我
    // 长度为x的字符串，一个窗口经过。x在我左边，x在我右边。x最小是1，最大是多少。单边最大就是我的位置（左右距离）
    // 从双边到了单边。双边的最大距离是左右的最短。剩下的是单边。小+大？
    // 最大的窗口是s整长，s左划过去，s右划过来，计算当前窗口经过我的个数，就是窗口的大小。
    // 如果全在右边，就是1+2+3+。。。n
    // 如果全在左边 n+n-1+。。。+1
    // 这是以它为首末两端的
    //  0 i n
    // 0 1 2 3 4 5   0123 1234 2345 012345 01234 12345 0123 1234 2345 012 123 234 345
    // 长度为3 个数为3，长度为4 个数为4 长度为2 个数为2 ，实际上考虑到 左边个
    // 双边 ，不能超过左右最小值，超过的话按单边计算，遍历起始点？
    //左不超i右不超n 当前窗口左边不过i，右边不超过末端，长度l，起始点t t<=i,t+l<n t+l>i
    //长度是n
    // 左起始 i+1 右结尾 n-i
    // 长度是l，l的开始在左边的i+1，l的结束在右边的n-i
    // 对于某个点i来说，l从1-n，l的个数是1-n 2-n-1 3-n-2，左边最大是i+1 右边最大是n-i
    // 这两个值中的小值是单边限制，左边允许个数和右边允许个数的最小值是两边的允许值（经过i的限制）
    // 还有一个限制，实际上的左右边界，start+l<n
    // n-j+1,长度是j，个数是n-j+1 ---当左右边界满足之后，需要考虑。左右边界是左右能给出的数目，不是真正的边界
    // 左右边界只是 左边给出的数目，右边给出的数目，其中的小值是左到右的字符串，实际上这个字符串超过了n的边界，所以要加上有意义字符串本身的限制
    // i+1个 n-i，左集合 内积 右集合 。我的做法是遍历长度，看这个长度的子字符串有多少存放了i。
    // 如果从长度的角度考虑 i+1个n-i，我需要考虑边界问题，但左右已经给出，溢出的边界是怎么出来的呢？s+l大于了n
    // i+1 和n-i肯定不会溢出，我用的l已经不是i+1中的起始了。实际上的长度虽然也是n。
    // 我做加和，i+1和n-i的最小值，不是i+1 * i+1 , 而是
    // i+1 n-i
    // 集合的不同角度考虑？

    public static void main(String[] args) {
        System.out.println(countVowels("aba"));//237
        System.out.println(" ");
        System.out.println(countVowels("noosabasboosa"));//237
    }
    //dp
    //n方复杂度 滑动窗口受害者本者
    public static long countVowels(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
        char[] vo = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vo.length; i++) {
            set.add(vo[i]);
        }
        long[] dp = new long[n];
        long count = 0;
        if (set.contains(word.charAt(0))) {
            dp[0]=1;
            count+=dp[0];
        }
        for (int i = 1; i < n; i++) {
            if (set.contains(word.charAt(i))) {
                dp[i]=dp[i-1]*2+1;
            }else{
                dp[i]=dp[i-1];
            }
            count+=dp[i];
        }
        return count;
    }
}
