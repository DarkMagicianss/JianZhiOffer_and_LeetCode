package LeetCode.动态规划.打家劫舍2;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 1];
        boolean[] flag = new boolean[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        flag[1] = true;
        if (nums[0] > nums[1]) {
            dp[2] = nums[0];
            flag[2] = flag[1];
        } else {
            dp[2] = nums[1];
            flag[2] = flag[2];
        }
        for (int i = 3; i <= nums.length; i++) {
            if (dp[i - 2] > dp[i - 3]) {
                if (dp[i - 1] > dp[i - 2] + nums[i - 1]) {
                    dp[i] = dp[i - 1];
                    flag[i] = flag[i - 1];
                } else {
                    dp[i] = dp[i - 2] + nums[i - 1];
                    flag[i] = flag[i - 2];
                }
            } else {
                if (dp[i - 1] > dp[i - 3] + nums[i - 1]) {
                    dp[i] = dp[i - 1];
                    flag[i] = flag[i - 1];
                } else {
                    dp[i] = dp[i - 3] + nums[i - 1];
                    flag[i] = flag[i - 3];
                }
            }
        }
        //System.out.println(Arrays.toString(flag));
        if (flag[nums.length]) {
            return dp[nums.length - 1];
        } else {
            return dp[nums.length];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{2, 3, 2}));
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 1, 3, 11}));
        System.out.println(s.rob(new int[]{0, 1}));
        System.out.println(s.rob(new int[]{5}));
        System.out.println(s.rob(new int[]{10, 20, 5}));
    }
}

