package LeetCode.动态规划.解码方法;

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int temp = s.charAt(i - 1) - '0';
            int last_temp = s.charAt(i - 2) - '0';
            if (temp == 0 || last_temp == 0) {
                if (temp == 0 && last_temp == 0) return 0;
                if (last_temp != 0 && 10 * last_temp + temp > 26) return 0;
                dp[i] = dp[i - 2];
            } else if (10 * last_temp + temp > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("226226"));
        System.out.println(s.numDecodings("2261010226"));
        System.out.println(s.numDecodings("1010"));
        System.out.println(s.numDecodings("10"));
        System.out.println(s.numDecodings("00"));
        System.out.println(s.numDecodings("1212"));
        System.out.println(s.numDecodings("100"));
        System.out.println(s.numDecodings("230"));
    }
}
