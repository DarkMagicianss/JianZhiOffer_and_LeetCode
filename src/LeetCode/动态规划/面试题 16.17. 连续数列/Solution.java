/**
 * @author LinHu
 * @version 2021/3/6
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1)return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
}
