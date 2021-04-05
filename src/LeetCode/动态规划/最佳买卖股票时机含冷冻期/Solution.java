
/**
 * @author LinHu
 * @version 2021/4/3
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(s.maxProfit(new int[]{1, 1, 2, 2}));
        System.out.println(s.maxProfit(new int[]{1, 2, 2, 4}));
    }
}
