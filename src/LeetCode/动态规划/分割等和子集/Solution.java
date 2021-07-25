package Solution;

import java.util.Arrays;

/**
 * 测试.
 *
 * @author LinHu
 * @version 2021-07-25 16:32
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1) return false;
        if (nums.length == 2) return nums[0] == nums[1];
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum %2 == 1) return false;
        int target = sum/2;
        if (maxNum > target) return false;
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        //dp[i][j]表示从nums的0到i通过一种取法拿到数求和为j的可行性
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            for (int j = 0; j < target + 1; j++) {
                //针对每个num[i]，dp[i][j]存在取不取这个元素的选择
                if(j < nums[i]) {//当前值比目标值大 肯定取不了
                    dp[i][j] = dp[i - 1][j];
                } else if (j > nums[i]) {//j > nums[j]
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else{
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[]{1,5,11,5}));
        System.out.println(s.canPartition(new int[]{1,7,2,3,8,10,11}));
        System.out.println(s.canPartition(new int[]{1,2,3,5}));
        System.out.println(s.canPartition(new int[]{1,2,5}));
    }
}
