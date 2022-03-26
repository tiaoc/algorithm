//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 642 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] arr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(arr, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    int i = 0;
                    char start = o1.charAt(0);
                    while (i < o1.length() && i < o2.length()) {
                        char tempa = o1.charAt(i), tempb = o2.charAt(i);
                        if (tempa < tempb) {
                            return 1;
                        } else if (tempa > tempb) {
                            return -1;
                        }
                        i++;
                    }
                    //尽量将长的排在前面----不行
                    //长字符串剩下的部分要和短字符串相比较。bingo!
                    if (o1.length() < o2.length() && compare(o1, o2.substring(i)) < 0 || o1.length() > o2.length() && compare(o1.substring(i), o2) < 0) {
                        return -1;//o1在前
                    }
                    return 1;//o2在前
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(arr[i]);
            }
            while (sb.charAt(0) == '0' && sb.length() > 1) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}