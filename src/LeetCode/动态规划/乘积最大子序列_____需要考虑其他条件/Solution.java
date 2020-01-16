package LeetCode.动态规划.乘积最大子序列_____需要考虑其他条件;


public class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int fushu_index = -1;
        int result = Integer.MIN_VALUE;
        int now_cheng = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i - 1] < 0) {
                if (fushu_index == -1) {//之前没有出现过负数
                    fushu_index = i - 1;
                    dp[i] = dp[i - 1] * nums[i - 1];
                } else {//之前已经出现过负数的index 乘上两者之间的正数的累乘
                    dp[i] = nums[i - 1] * nums[fushu_index] * now_cheng;
                    if (dp[fushu_index] > 0) dp[i] *= dp[fushu_index];//若之前负数之前的dp为正 则乘进来
                    fushu_index = i - 1;//更新负数位置
                }
                now_cheng = 1;
            } else if (nums[i - 1] == 0) {
                fushu_index = -1;
                dp[i] = dp[i - 1] * nums[i - 1];
                now_cheng = 1;
            } else {//nums[i -1] > 0
                //之前的dp为正 则当前的乘上之前的dp 否则dp为当前的数值
                dp[i] = nums[i - 1] * (dp[i - 1] > 0 ? dp[i - 1] : 1);
                now_cheng *= nums[i - 1];//累积中间的正数
            }
            result = Math.max(result, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(s.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(s.maxProduct(new int[]{-2, 3, 0, 5, -1, -2, 1, -3}));
        System.out.println(s.maxProduct(new int[]{2, -5, -2, -4, 3}));
        System.out.println(s.maxProduct(new int[]{-2, 3, -4}));
    }
}

