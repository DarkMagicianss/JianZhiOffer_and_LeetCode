package LeetCode.动态规划.通配符匹配_____仔细思考呀;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) return true;
        //尝试使用动态规划解决问题
        int rows = s.length() + 1;
        int cols = p.length() + 1;
        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;
        //其中当p.length()为0时 对应的dp[i][0]全为false
        for (int j = 1; j < cols; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {//非*直接break;
                break;
            }
        }
        //进行dp扩展
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
                }
                //else默认dp已经为false
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "adceb";
        String s2 = "*a*b";
        System.out.println(s.isMatch(s1, s2));
    }
}
