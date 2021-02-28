package com.xiaomi.ad.osctask.ad;

/**
 * @author LinHu
 * @version 2021/2/27
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int now_cost = i == cost.length? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + now_cost;
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(s.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
