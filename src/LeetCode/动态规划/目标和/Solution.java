package Solution;

import java.util.Arrays;

/**
 * text.
 *
 * @author LinHu
 * @version 2021-08-08 18:56
 */
public class Solution {
    //数组元素和为sum,添加-号的和为neg,则其余添加+号的为sum-neg,得出target=(sum-neg)-neg -> neg=(sum-target)/2
    //因此问题转换为在数组nums中选取若干元素，使得这些元素之和等于neg，计算选取元素的方案数
    //可以再优化成一维dp
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
//    public int findTargetSumWays(int[] nums, int target) {
//        if (nums == null || nums.length <= 0) return 0;
//        if (nums.length == 1) return (nums[0] == target || nums[0] == -target) ? 1 : 0;
//        int allSum = Arrays.stream(nums).sum();
//        if (allSum < Math.abs(target) || (allSum - target)%2 != 0) return 0;
//        int[] oldDp = new int[allSum * 2 + 1];
//        int[] dp = new int[allSum * 2 + 1];
//        oldDp[nums[0] + allSum] += 1;
//        oldDp[-nums[0] + allSum] += 1;
//        // 从0-i个数字中组成j的种类个数
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = -allSum; j <= allSum; j++) {
//                int add = j - nums[i] >= -allSum ? oldDp[j - nums[i] + allSum] : 0;
//                int sub = j + nums[i] <= allSum ? oldDp[j + nums[i] + allSum] : 0;
//                dp[j + allSum] = add + sub;
//            }
//            oldDp = dp;
//            dp = new int[allSum * 2 + 1];
//        }
//        return oldDp[target + allSum];
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(s.findTargetSumWays(new int[]{1}, 1));
        System.out.println(s.findTargetSumWays(new int[]{1,0}, 1));
        System.out.println(s.findTargetSumWays(new int[]{0,1}, 1));
    }
}
