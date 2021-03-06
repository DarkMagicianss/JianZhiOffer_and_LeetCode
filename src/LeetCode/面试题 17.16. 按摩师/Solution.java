/**
 * @author LinHu
 * @version 2021/3/6
 */
public class Solution {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1,2,3,1};
        int[] nums2 = new int[]{2,7,9,3,1};
        int[] nums3 = new int[]{2,1,4,5,3,1,1,3};
        System.out.println(s.massage(nums1));
        System.out.println(s.massage(nums2));
        System.out.println(s.massage(nums3));
    }
}
