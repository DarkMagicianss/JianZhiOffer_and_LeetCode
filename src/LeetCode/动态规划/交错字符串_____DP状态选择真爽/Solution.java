package LeetCode.动态规划.交错字符串_____DP状态选择真爽;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len1 == 0) return s2.equals(s3);//若其中一个为空字符串 则只需判断另一个和目标是否相等
        if (len2 == 0) return s1.equals(s3);//若其中一个为空字符串 则只需判断另一个和目标是否相等
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        //i为0
        for (int j = 1; j < len2 + 1; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
            //System.out.print(dp[0][j]+" ");
        }
        //System.out.println();
        //j为0
        for (int i = 1; i < len1 + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
            //System.out.print(dp[i][0]+" ");
        }
        //System.out.println();
        //其他
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j] = (dp[i][j - 1] == true && s3.charAt(i + j - 1) == s2.charAt(j - 1)) ||
                        (dp[i - 1][j] == true && s3.charAt(i + j - 1) == s1.charAt(i - 1));
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        Solution s = new Solution();
        System.out.println(s.isInterleave(s1, s2, s3));
    }
}
