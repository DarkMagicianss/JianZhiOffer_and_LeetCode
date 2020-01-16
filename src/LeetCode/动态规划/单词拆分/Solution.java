package LeetCode.动态规划.单词拆分;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        //听说是一个完全背包问题 即物品可以无限拿
        boolean[] dp = new boolean[s.length() + 1];//表示[0,i-1]是否能由wordDict完全组成
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String temp = wordDict.get(j);
                if (i >= temp.length() && temp.equals(s.substring(i - temp.length(), i))) {
                    dp[i] = dp[i - temp.length()];
                    if (dp[i] == true) break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"});
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list));
    }
}
