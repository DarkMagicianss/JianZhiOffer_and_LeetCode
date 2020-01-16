package LeetCode.动态规划.打家劫舍;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 1, 3, 11}));
        System.out.println(s.rob(new int[]{0, 1}));
        System.out.println(s.rob(new int[]{5}));
        System.out.println(s.rob(new int[]{10, 20, 5}));
    }
}

