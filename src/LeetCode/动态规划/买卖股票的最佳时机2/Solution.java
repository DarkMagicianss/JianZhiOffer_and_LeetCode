package LeetCode.动态规划.买卖股票的最佳时机2;


public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]){
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(s.maxProfit(arr));
    }
}
