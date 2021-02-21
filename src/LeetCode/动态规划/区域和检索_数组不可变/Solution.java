package com.xiaomi.ad.osctask.ad.区域和检索_数组不可变;


/**
 * @author LinHu
 * @version 2021/2/21
 */
public class Solution {
    int[] dp;
    public Solution(int[] nums) {
        int size = nums.length;
        if (size == 0) return;
        dp = new int[size];
        dp[0] = nums[0];
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        Solution solution = new Solution(nums);
        System.out.println(solution.sumRange(0,2));
        System.out.println(solution.sumRange(2,5));
        System.out.println(solution.sumRange(0,5));
    }
}
