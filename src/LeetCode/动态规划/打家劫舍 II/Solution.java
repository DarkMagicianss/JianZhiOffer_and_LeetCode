/**
 * @author LinHu
 * @version 2021/3/27
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;
        return Math.max(sub_rob(nums,0,len - 1),
                sub_rob(nums,1,len - 1));
    }
    public int sub_rob(int[] nums, int start_index, int len){
        if (len == 1) return nums[start_index];
        if (len == 2) return Math.max(nums[start_index], nums[start_index + 1]);
        int[] dp = new int[len + 1];
        dp[0] = nums[start_index];
        dp[1] = Math.max(nums[start_index], nums[start_index + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start_index]);
        }
        return dp[len - 1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str1 = "leetcode";
        String str2 = "applepenapple";
        String str3 = "catsandog";

        System.out.println(s.rob(new int[]{1,2,3,1}));
        System.out.println(s.rob(new int[]{2,7,9,3,1}));
        System.out.println(s.rob(new int[]{1,2,1,1}));
        System.out.println(s.rob(new int[]{-6,-1,4}));
        System.out.println(s.rob(new int[]{0,-1,4}));
        System.out.println(s.rob(new int[]{0,1,4}));
        System.out.println(s.rob(new int[]{2,-5,-2,-4,3}));
        System.out.println(s.rob(new int[]{1,-1,-1}));
    }
}
