package LeetCode.动态规划.买卖股票的最佳时机1;


public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int start_index = 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[start_index]) start_index = i;
            else result = Math.max(result, prices[i] - prices[start_index]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{7, 1, 4, 3, 0, 9};
        System.out.println(s.maxProfit(arr));
    }
}
