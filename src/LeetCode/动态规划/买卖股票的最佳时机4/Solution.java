package LeetCode.动态规划.买卖股票的最佳时机4;


public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2){
            return maxProfit(prices);
        }
        //状态分别为天数 可交易的最大次数 0表示没有股票 1表示持有股票
        int len = prices.length;
        int[][] dp = new int[k + 1][2];
        //因为每一天的状态都只和前一天的状态相关 因此没有必要存储这么多天的状态 降为成二维
        for (int j = 0; j <= k; j++) {//初始化 第0天状态下的状态
            //dp[j][0] = 0;
            dp[j][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = k; j >= 1; j--) {
                //今天没有股票的路径 1.保持昨天没有股票的状态 2.将昨天的股票今天卖出 得到利润
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i - 1]);
                //今天持有股票的路径 1.保持昨天持有股票的状态 2.将股票今天买入 减少利润(因为这里要买入 因此第二个状态 最大交易次数 从j-1到j加了一次交易)
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i - 1]);
            }
        }
        return dp[k][0];
    }

    // 贪心算法处理不限制次数的交易 看来大部分的数据都是不限定交易次数一般 2333 从216ms------>8ms
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];// 本天与后一天差值就是收益
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(s.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
