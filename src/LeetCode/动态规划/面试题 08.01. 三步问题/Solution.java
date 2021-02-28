package com.xiaomi.ad.osctask.ad;

/**
 * @author LinHu
 * @version 2021/2/27
 */
public class Solution {
    public int waysToStep(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int a = 1, b = 2, c = 4;
        if (dp[n] != 0) return (int)dp[n];
        for (int i = 4; i <= n; i++) {
            dp[i] = ((a+ b)%1000000007 + c)%1000000007;
            a = b;
            b = c;
            c = dp[i];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.waysToStep(1));
        System.out.println(s.waysToStep(2));
        System.out.println(s.waysToStep(3));
        System.out.println(s.waysToStep(4));
        System.out.println(s.waysToStep(5));
    }
}
