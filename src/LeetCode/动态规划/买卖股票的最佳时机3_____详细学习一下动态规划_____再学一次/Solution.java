package LeetCode.动态规划.买卖股票的最佳时机3_____详细学习一下动态规划_____再学一次;


public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp_i10 = 0;
        int dp_i11 = -prices[0];
        int dp_i20 = 0;
        int dp_i21 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            //System.out.println(dp_i10 + "  " + dp_i11 + "  " + dp_i20 + "  " + dp_i21);
        }
        return dp_i20;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{2, 1, 2, 0, 1};
        System.out.println(s.maxProfit(arr));
    }
}
