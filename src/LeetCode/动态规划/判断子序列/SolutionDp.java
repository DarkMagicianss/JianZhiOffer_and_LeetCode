package com.xiaomi.ad.osctask.ad;

/**
 * @author LinHu
 * @version 2021/2/27
 */
public class SolutionDp {
    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0 && s.length() == 0) return true;
        if (t.length() == 0 && s.length() != 0) return false;
        if (t.length() != 0 && s.length() == 0) return true;
        int[][] dp = new int[t.length() + 2][26];
        for (int i = 1; i <= t.length(); i++) {
            dp[i][t.charAt(i - 1) - 'a'] = i;
        }
        for (int i = t.length(); i > 0; i--) {
            for (int j = 0; j < 26; j++) {
                if(t.charAt(i - 1) == j + 'a'){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(dp[index + 1][s.charAt(i) - 'a'] == 0) return false;
            index = dp[index + 1][s.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionDp s = new SolutionDp();
        System.out.println(s.isSubsequence("abc","ahbgdc"));
        System.out.println(s.isSubsequence("axc","ahbgdc"));
        System.out.println(s.isSubsequence("aaaaaa","bbaaaa"));
    }
}
